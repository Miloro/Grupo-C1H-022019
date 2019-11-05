package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.ServiceProfileRepository;
import com.viandasya.webservice.dtos.SearchDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final ServiceProfileRepository serviceProfileRepository;
    private Map<String, Function<SearchDTO,Page<Menu>>> pageMenusFunctions;

    public MenuService(MenuRepository menuRepository, ServiceProfileRepository servicerepository) {
        this.menuRepository = menuRepository;
        this.serviceProfileRepository = servicerepository;
        this.setPageMenusFunctions();
    }

    @Transactional
    public Menu createMenu(Menu menu,Long id){
        ServiceProfile service = serviceProfileRepository.findById(id).get();
        service.addMenu(menu);
        return menuRepository.save(menu);
    }

    @Transactional
    public Menu getMenu(Long id){
        return menuRepository.findById(id).get();
    }

    @Transactional
    public Menu updateMenu(Menu convertToEntity, Long id) {
        Menu menu = menuRepository.findById(id).get();
        menu.setName(convertToEntity.getName());
        menu.setDescription(convertToEntity.getDescription());
        menu.setCategories(convertToEntity.getCategories());
        menu.setValidity(convertToEntity.getValidity());
        menu.setOffers(convertToEntity.getOffers());
        menu.setMaxAmountPerDay(convertToEntity.getMaxAmountPerDay());
        menu.setCookingTime(convertToEntity.getCookingTime());
        menuRepository.save(menu);
        return menuRepository.findById(id).get();
    }

    @Transactional
    public Page<Menu> search(SearchDTO searchDTO) {
        return this.pageMenusFunctions.get(searchDTO.getFilterField()).apply(searchDTO);
    }

    private void setPageMenusFunctions() {
        this.pageMenusFunctions = new HashMap<>();
        this.pageMenusFunctions.put("name",(searchDTO ->
                this.menuRepository.findByNameContaining(searchDTO.getFilterQuery(), searchDTO.getPageRequest())));
        this.pageMenusFunctions.put("category",(searchDTO ->
                this.menuRepository.findByCategoriesContaining(searchDTO.getFilterQuery(), searchDTO.getPageRequest())));
        this.pageMenusFunctions.put("city",(searchDTO ->
                this.menuRepository.findByServiceProfileLocationCityContaining(searchDTO.getFilterQuery(), searchDTO.getPageRequest())));

    }
}
