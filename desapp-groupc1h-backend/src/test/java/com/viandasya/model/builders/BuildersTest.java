package com.viandasya.model.builders;


import com.viandasya.model.menu.Menu;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.DayTimeSlot;
import com.viandasya.model.timeslot.HoursTimeSlot;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.ServiceInfo;
import com.viandasya.model.user.ServiceProfile;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static com.viandasya.model.builders.ClientProfileBuilder.anyClientProfile;
import static com.viandasya.model.builders.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.MenuBuilder.anyMenu;
import static com.viandasya.model.builders.ServiceInfoBuilder.anyServiceInfo;
import static org.junit.Assert.*;

public class BuildersTest {

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder() {
        ClientProfile anyClientProfile  = new ClientProfileBuilder()
                .setName("name")
                .setLastName("lastName")
                .setEmail("email")
                .setPhoneNumber(12345)
                .setCity("city")
                .setAdress("adress")
                .createClientProfile();

        assertEquals(anyClientProfile.getName(), "name");
    }

    @Test
    public void testIsValid_WhenICanCreateADateTimeSlotWithDateTimeSlotBuilder() {
        DateTimeSlot anyDateTimeSlot  = new DateTimeSlotBuilder()
                .setSince(LocalDateTime.now().minusDays(12))
                .setFrom(LocalDateTime.now().minusDays(7))
                .createDateTimeSlot();

        assertTrue(anyDateTimeSlot.getSince().isBefore(anyDateTimeSlot.getFrom()));
    }

    @Test
    public void testIsValid_WhenICanCreateADayTimeSlotWithDayTimeSlotBuilder() {
        DayTimeSlot anyDateTimeSlot  = new DayTimeSlotBuilder()
                .setDay(DayOfWeek.MONDAY)
                .setHoursTimeSlots(Collections.singletonList(new HoursTimeSlot(LocalTime.NOON, LocalTime.MIDNIGHT)))
                .createDayTimeSlot();

        assertEquals(anyDateTimeSlot.getDay(),DayOfWeek.MONDAY);
    }

    /*
    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder() {
        List<Order> orders = new ArrayList<>();
        Menu anyMenu = new MenuBuilder()
                .setName("aaaaa")
                .setDescription("aaaaaaaaaaaaaaaaaaaaaaa")
                .setCategory(Collections.singletonList(Category.GREEN))
                .setDeliveryPrice(30)
                .setValidity(anyDateTimeSlot().createDateTimeSlot())
                .setDeliveryDays(anyDayTimeSlot().createDayTimeSlot())
                .setAverageDeliveryTime(48)
                .setMaxAmountPerDay(33)
                .setOrders(orders)
                .createMenu();

        assertEquals(,);
    }
    */

    @Test
    public void testIsValid_WhenICanCreateAOrderWithOrderBuilder() {
        Order anyOrder = new OrderBuilder()
                .setAmount(1234)
                .setOffers(Collections.singletonList(new Offer(30, 1)))
                .setScore(2)
                .setState(OrderState.CONFIRMED)
                .setIsDelivery(false)
                .setMenu(anyMenu().createMenu())
                .setClient(anyClientProfile().createClientProfile())
                .createOrder();

        assertEquals(anyOrder.getState(), OrderState.CONFIRMED);
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder() {
        ServiceInfo anyServiceInfo = new ServiceInfoBuilder()
                .setName("El Rodeo")
                .setLogo(":)")
                .setAdress("San Martin 675")
                .setDescription("Proveemos hamburguesas y papas fritas")
                .setWebsite("www.rodeoquilmes.com.ar")
                .setEMail("rodeoquilmes01@gmail.com")
                .setPhoneNumber(42501324)
                .createServiceInfo();

        assertEquals(anyServiceInfo.getName(), "El Rodeo");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceProfileWithServiceProfileBuilder() {
        List<Menu> menus = new ArrayList<>();
        ServiceProfile anyServiceProfile = new ServiceProfileBuilder()
                .setServiceInfo(anyServiceInfo().createServiceInfo())
                .setServiceDays(anyDateTimeSlot().createDateTimeSlot())
                .setMenus(menus)
                .setBalance(new Balance(0))
                .createServiceProfile();

        assertEquals(anyServiceProfile.getMenus().size(), 0);
    }





}
