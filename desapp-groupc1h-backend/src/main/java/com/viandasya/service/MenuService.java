package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.ServiceProfileRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final ServiceProfileRepository serviceProfileRepository;

    public MenuService(MenuRepository menuRepository, ServiceProfileRepository servicerepository) {
        this.menuRepository = menuRepository;
        this.serviceProfileRepository = servicerepository;
    }

    @Transactional
    public Menu createMenu(Menu menu,Long id){
        ServiceProfile service = serviceProfileRepository.findById(id).get();
        service.addMenu(menu);
        return menuRepository.save(menu);
    }

    @Transactional
    public Menu getMenu(Long id){
        Menu menu = menuRepository.findById(id).get();
        return menu;
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
}
