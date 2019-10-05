package com.viandasya.model.user;

import com.viandasya.model.menu.Menu;


import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static com.viandasya.model.builders.user.ServiceProfileBuilder.anyServiceProfile;


public class ServiceProfileTest {

    @Test
    public void addMenuAddsMenuToList() {
        ServiceProfile serviceProfile = anyServiceProfile().setMenus(new ArrayList<>()).createServiceProfile();

        Menu menu = Mockito.mock(Menu.class);
        serviceProfile.addMenu(menu);

        Assert.assertTrue(serviceProfile.getMenus().contains(menu));
    }


    @Test
    public void testHas20ValidMenusServiceWithValid20MenusGivesTrue() {
        ServiceProfile serviceProfile = anyServiceProfile().setMenus(this.createNMockValidMenus(20)).createServiceProfile();

        Assert.assertTrue(serviceProfile.has20ValidMenus());
    }

    @Test

    public void testHas20ValidMenusServiceWith17ValidMenusGivesFalse() {
        ServiceProfile serviceProfile = anyServiceProfile().setMenus(this.createNMockValidMenus(17)).createServiceProfile();

        Assert.assertFalse(serviceProfile.has20ValidMenus());
    }

    private List<Menu> createNMockValidMenus(int n) {
        List<Menu> menus = new ArrayList<>();
        Menu mockMenu;
        for (int i = 0; i < n; i++) {
            mockMenu = Mockito.mock(Menu.class);
            Mockito.when(mockMenu.isValid()).thenReturn(true);
            menus.add(mockMenu);
        }
        return menus;
    }

}