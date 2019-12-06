package com.viandasya.model.user;

import com.viandasya.model.menu.Menu;


import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.viandasya.model.builders.menu.MenuBuilder.anyMenu;
import static com.viandasya.model.builders.user.ServiceProfileBuilder.anyServiceProfile;


public class ServiceProfileTest {

    @Test
    public void addMenuAddsMenuToList() {
        ServiceProfile serviceProfile = anyServiceProfile().createServiceProfile();

        Menu menu = Mockito.mock(Menu.class);
        serviceProfile.addMenu(menu);

        Assert.assertTrue(serviceProfile.getMenus().contains(menu));
    }


    @Test
    public void testHas20ValidMenusServiceWithValid20MenusGivesTrue() {
        ServiceProfile serviceProfile = anyServiceProfile().createServiceProfile();
        this.createNMockValidMenus(20).forEach(serviceProfile::addMenu);

        Assert.assertTrue(serviceProfile.has20ValidMenus());
    }

    @Test

    public void testHas20ValidMenusServiceWith17ValidMenusGivesFalse() {
        ServiceProfile serviceProfile = anyServiceProfile().createServiceProfile();
        this.createNMockValidMenus(17).forEach(serviceProfile::addMenu);

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

    @Test
    public void testUpdateScoreUpdatesScoreOfServiceProfileAndReturnsAListOfUpdatedMenus() {
        List<Menu> mockMenus = new ArrayList<>();
        Arrays.asList(4.23,3.12,5.5,4.10,5.5,1.5,4.25,5.75,2.12,1.4,
                3.1,4.5,5.5,2.8,4.3,3.5,1.0,5.0,3.0,4.0).forEach(aDouble -> {
            Menu mockMenu = Mockito.mock(Menu.class);
            Mockito.when(mockMenu.updateScore()).thenReturn(true);
            Mockito.when(mockMenu.getScore()).thenReturn(aDouble);
            mockMenus.add(mockMenu);
        });

        ServiceProfile serviceProfile = anyServiceProfile().createServiceProfile();
        mockMenus.forEach(serviceProfile::addMenu);
        List<Menu> menus = serviceProfile.updateScore();

        Assert.assertEquals(3.7, serviceProfile.getScore(), 0.1);
        Assert.assertTrue(menus.containsAll(mockMenus));
    }

}