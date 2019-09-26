package com.viandasya.model.user;

import com.viandasya.model.menu.Menu;

import com.viandasya.model.timeslot.TimeSlot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static com.viandasya.model.builders.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.ServiceProfileBuilder.anyServiceProfile;

@RunWith(MockitoJUnitRunner.class)
public class ServiceProfileTest {

    @Test
    public void testHas20ValidMenus_serviceWithValid20MenusGivesTrue() {
        ServiceProfile serviceProfile = anyServiceProfile().createServiceProfile();
        TimeSlot timeSlot = anyDateTimeSlot().createDateTimeSlot();
        List<Menu> menus = this.createNMockValidMenus(20);
        Balance balance = new Balance(0);
        Service service = new Service(serviceProfile, timeSlot, menus,balance);


        Assert.assertTrue(service.has20ValidMenus());
    }

    @Test
    public void testHas20ValidMenus_serviceWith17ValidMenusGivesFalse() {
        ServiceProfile serviceProfile = anyServiceProfile().createServiceProfile();
        TimeSlot timeSlot = anyDateTimeSlot().createDateTimeSlot();
        List<Menu> menus = this.createNMockValidMenus(17);
        Balance balance = new Balance(0);
        Service service = new Service(serviceProfile, timeSlot, menus,balance);

        Assert.assertFalse(service.has20ValidMenus());
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