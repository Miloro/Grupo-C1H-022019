package com.viandasya.model.user;

import com.viandasya.model.menu.Menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static com.viandasya.model.builders.ServiceProfileBuilder.anyServiceProfile;

@RunWith(MockitoJUnitRunner.class)
public class ServiceProfileTest {

    @Test
    public void testHas20ValidMenus_serviceWithValid20MenusGivesTrue() {
        ServiceProfile service = anyServiceProfile().setMenus(this.createNMockValidMenus(20)).createServiceProfile();

        assertTrue(service.has20ValidMenus());
    }

    @Test
    public void testHas20ValidMenus_serviceWith17ValidMenusGivesFalse() {
        ServiceProfile service = anyServiceProfile().setMenus(this.createNMockValidMenus(17)).createServiceProfile();

        assertFalse(service.has20ValidMenus());
    }

    private List<Menu> createNMockValidMenus(int n) {
        List<Menu> menus = new ArrayList<>();
        Menu mockMenu;
        for (int i = 0; i < n; i++) {
            mockMenu = mock(Menu.class);
            when(mockMenu.isValid()).thenReturn(true);
            menus.add(mockMenu);
        }
        return menus;
    }


}