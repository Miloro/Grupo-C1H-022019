package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.ServiceProfileRepository;
import com.viandasya.webservice.Search;
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
    private Map<String, Function<Search,Page<Menu>>> pageMenusFunctions;

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
        menu.setCategory(convertToEntity.getCategory());
        menu.setValidity(convertToEntity.getValidity());
        menu.setOffers(convertToEntity.getOffers());
        menu.setMaxAmountPerDay(convertToEntity.getMaxAmountPerDay());
        menu.setCookingTime(convertToEntity.getCookingTime());
        menuRepository.save(menu);
        return menuRepository.findById(id).get();
    }

    @Transactional
    public Page<Menu> search(Search search) {
        return this.pageMenusFunctions.get(search.getFilterField()).apply(search);
    }

    private void setPageMenusFunctions() {
        this.pageMenusFunctions = new HashMap<>();
        this.pageMenusFunctions.put("name",(search ->
                this.menuRepository.findByNameContaining(search.getFilterQuery(), search.getPageRequest())));
        this.pageMenusFunctions.put("category",(search ->
                this.menuRepository.findByCategoryContaining(search.getFilterQuery(), search.getPageRequest())));
        this.pageMenusFunctions.put("city",(search ->
                this.menuRepository.findByServiceProfileLocationCityContaining(search.getFilterQuery(), search.getPageRequest())));

    }
}
