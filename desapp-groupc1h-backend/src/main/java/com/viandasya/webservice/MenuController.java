package com.viandasya.webservice;

import com.viandasya.model.menu.Menu;
import com.viandasya.service.MenuService;
import com.viandasya.webservice.dtos.CreateMenuDTO;
import com.viandasya.webservice.dtos.MenuDTO;
import com.viandasya.webservice.dtos.MenuPreviewDTO;
import com.viandasya.webservice.dtos.SearchDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {
    private final MenuService menuService;
    private final ModelMapper modelMapper;

    public MenuController(MenuService menuService, ModelMapper modelMapper) {
        this.menuService = menuService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("service/{id}/menu")
    public void create(@PathVariable Long id, @RequestBody CreateMenuDTO createMenuDTO){
        Menu menu = modelMapper.map(createMenuDTO, Menu.class);
        this.menuService.createMenu(menu, id);
    }

    @GetMapping("menu/{id}")
    public MenuDTO getMenu(@PathVariable Long id){
        return convertToDto(menuService.getMenu(id));
    }

    @PutMapping("menu/{id}")
    public MenuDTO updateMenu(@PathVariable Long id, @RequestBody MenuDTO menuDTO){
        return convertToDto(menuService.updateMenu(convertToEntity(menuDTO),id));
    }

    @PostMapping("menus/search")
    public Page<MenuPreviewDTO> search(@RequestBody SearchDTO searchDTO){
        Page<Menu> pagedMenus = menuService.search(searchDTO);
        return pagedMenus.map(menu -> modelMapper.map(menu, MenuPreviewDTO.class));
    }

    @GetMapping("menus/price")
    public void updatePrice() {
        this.menuService.updateMenuPrice();
    }

    private MenuDTO convertToDto(Menu menu) {
        MenuDTO menuDTO = modelMapper.map(menu, MenuDTO.class);
        menuDTO.setDeliveryInfo(menu.getDeliveryInfo());
        return menuDTO;
    }

    private Menu convertToEntity(MenuDTO menuDTO) {
        Menu menu = modelMapper.map(menuDTO, Menu.class);
        menu.addDeliveryInfo(menuDTO.getDeliveryInfoConverted());
        return menu;
    }

}
