package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.ServiceProfileRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
