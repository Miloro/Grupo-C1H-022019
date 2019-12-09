package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.ServiceProfileRepository;
import com.viandasya.webservice.dtos.MenuOrderCountDTO;
import com.viandasya.webservice.dtos.SearchDTO;
import com.viandasya.exceptions.Maximum20ValidMenusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final ServiceProfileRepository serviceProfileRepository;
    private Map<String, Function<SearchDTO, Page<Menu>>> pageMenusFunctions;
    private final static Logger logger = LoggerFactory.getLogger(MenuService.class);


    public MenuService(MenuRepository menuRepository, ServiceProfileRepository servicerepository) {
        this.menuRepository = menuRepository;
        this.serviceProfileRepository = servicerepository;
        this.setPageMenusFunctions();
    }

    @Transactional
    public void createMenu(Menu menu, Long serviceId) throws RuntimeException {
        this.serviceProfileRepository.findById(serviceId).ifPresent(serviceProfile -> {
            if (serviceProfile.has20ValidMenus()) {
                throw new Maximum20ValidMenusException();
            }
            serviceProfile.addMenu(menu);
            this.serviceProfileRepository.save(serviceProfile);
        });
    }

    @Transactional
    public Menu getMenu(Long id) {
        return menuRepository.findById(id).get();
    }

    @Transactional
    public Menu updateMenu(Menu convertToEntity, Long id) {
        Menu menu = menuRepository.findById(id).get();
        menu.setName(convertToEntity.getName());
        menu.setDescription(convertToEntity.getDescription());
        menu.setCategories(convertToEntity.getCategories());
        menu.setValidity(convertToEntity.getValidity());
        menu.setPriceHandler(convertToEntity.getPriceHandler());
        menu.setMaxAmountPerDay(convertToEntity.getMaxAmountPerDay());
        menu.setCookingTime(convertToEntity.getCookingTime());
        menuRepository.save(menu);
        return menuRepository.findById(id).get();
    }

    @Scheduled(cron = "0 0 */5 * * *")
    @Transactional
    public void updateMenuPrice() {
        logger.info("Beginning update of menu prices....");
        for (MenuOrderCountDTO menuOrderCountDTO : this.menuRepository.findAllAsToUpdateMenuDTO()) {
            boolean isUpdated = menuOrderCountDTO.getMenu().getPriceHandler()
                    .updateCurrent(menuOrderCountDTO.getOrderCount());
            if (isUpdated) {
                this.menuRepository.save(menuOrderCountDTO.getMenu());
            }
        }
        logger.info("Price update successfull");
    }

    @Transactional
    public List<Menu> getAllMenus(){
        return this.menuRepository.findAll();
    }

    @Transactional
    public Page<Menu> search(SearchDTO searchDTO) {
        return this.pageMenusFunctions.get(searchDTO.getFilterField()).apply(searchDTO);
    }

    private void setPageMenusFunctions() {
        this.pageMenusFunctions = new HashMap<>();
        this.pageMenusFunctions.put("name", (searchDTO ->
                this.menuRepository.findByNameContainingIgnoreCaseAndScoreGreaterThanEqualOrScoreNull(searchDTO.getFilterQuery(), 2.0,
                        searchDTO.getPageRequest())));
        this.pageMenusFunctions.put("city", (searchDTO ->
                this.menuRepository.findByServiceProfileLocationCityContainsIgnoreCaseAndScoreGreaterThanEqualOrScoreNull(searchDTO.getFilterQuery(), 2.0,
                        searchDTO.getPageRequest())));
        this.pageMenusFunctions.put(null, (searchDTO ->
                this.menuRepository.findByScoreGreaterThanEqualOrScoreNull(2.0, searchDTO.getPageRequest())));

    }

}
