package com.viandasya.model.builders;


import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.DayTimeSlot;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.ServiceInfo;
import com.viandasya.model.user.ServiceProfile;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static com.viandasya.model.builders.ClientProfileBuilder.anyClientProfile;
import static com.viandasya.model.builders.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.DayTimeSlotBuilder.anyDayTimeSlot;
import static com.viandasya.model.builders.MenuBuilder.anyMenu;
import static com.viandasya.model.builders.ServiceInfoBuilder.anyServiceInfo;
import static com.viandasya.model.builders.ServiceProfileBuilder.anyServiceProfile;
import static org.junit.Assert.*;

public class BuildersTest {

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder() {
        ClientProfile anyClientProfile  = new ClientProfileBuilder()
                .setName("name")
                .createClientProfile();

        assertEquals(anyClientProfile.getName(), "name");
    }

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder2() {
        ClientProfile anyClientProfile  =  anyClientProfile()
                .setLastName("lastName")
                .createClientProfile();

        assertEquals(anyClientProfile.getLastName(), "lastName");
    }

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder3() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setEmail("email")
                .createClientProfile();

        assertEquals(anyClientProfile.getEmail(), "email");
    }

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder4() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setPhoneNumber(12345)
                .createClientProfile();

        assertEquals(anyClientProfile.getPhoneNumber(), 12345,0);
    }

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder5() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setCity("city")
                .createClientProfile();

        assertEquals(anyClientProfile.getCity(), "city");
    }

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder6() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setAdress("adress")
                .createClientProfile();

        assertEquals(anyClientProfile.getAdress(), "adress");
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
        DayTimeSlot anyDateTimeSlot  =  anyDayTimeSlot()
                .setDay(DayOfWeek.MONDAY)
                .createDayTimeSlot();

        assertEquals(anyDateTimeSlot.getDay(),DayOfWeek.MONDAY);
    }


    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder() {
        Menu anyMenu = anyMenu()
                .setName("aaaaa")
                .createMenu();

        assertEquals(anyMenu.getName(),"aaaaa");
    }

    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder2() {
        Menu anyMenu = anyMenu()
                .setDescription("aaaaaaaaaaaaaaaaaaaaaaa")
                .createMenu();

        assertEquals(anyMenu.getDescription(),"aaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder3() {
        Menu anyMenu = anyMenu()
                .setCategory(Collections.singletonList(Category.GREEN))
                .createMenu();

        assertEquals(anyMenu.getCategory().get(0),Category.GREEN);
    }

    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder4() {
        Menu anyMenu = anyMenu()
                .setDeliveryPrice(30)
                .createMenu();

        assertEquals(anyMenu.getDeliveryPrice(),30,0);
    }


    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder5() {
        Menu anyMenu = anyMenu()
                .setAverageDeliveryTime(48)
                .createMenu();

        assertEquals(anyMenu.getAverageDeliveryTime(),48,0);
    }

    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder8() {
        Menu anyMenu = anyMenu()
                .setMaxAmountPerDay(33)
                .createMenu();

        assertEquals(anyMenu.getMaxAmountPerDay(),33,0);
    }

    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder9() {
        List<Order> orders = new ArrayList<>();
        Menu anyMenu = anyMenu()
                .setOrders(orders)
                .createMenu();

        assertEquals(anyMenu.getOrders().size(),0);
    }

    @Test
    public void testIsValid_WhenICanCreateAOrderWithOrderBuilder() {
        Order anyOrder = new OrderBuilder()
                .setAmount(1234)
                .createOrder();

        assertEquals(anyOrder.getAmount(), 1234, 0);
    }

    @Test
    public void testIsValid_WhenICanCreateAOrderWithOrderBuilder2() {
        Order anyOrder = new OrderBuilder()
                .setScore(2)
                .createOrder();

        assertEquals(anyOrder.getScore(), 2,0);
    }

    @Test
    public void testIsValid_WhenICanCreateAOrderWithOrderBuilder3() {
        Order anyOrder = new OrderBuilder()
                .setState(OrderState.CONFIRMED)
                .createOrder();

        assertEquals(anyOrder.getState(), OrderState.CONFIRMED);
    }

    @Test
    public void testIsValid_WhenICanCreateAOrderWithOrderBuilder4() {
        Order anyOrder = new OrderBuilder()
                .setIsDelivery(false)
                .createOrder();

        assertEquals(anyOrder.getDelivery(), false);
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setName("El Rodeo")
                .createServiceInfo();

        assertEquals(anyServiceInfo.getName(), "El Rodeo");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder2() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setLogo(":)")
                .createServiceInfo();

        assertEquals(anyServiceInfo.getLogo(), ":)");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder3() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setAdress("San Martin 675")
                .createServiceInfo();

        assertEquals(anyServiceInfo.getAdress(), "San Martin 675");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder4() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setDescription("Proveemos hamburguesas y papas fritas")
                .createServiceInfo();

        assertEquals(anyServiceInfo.getDescription(), "Proveemos hamburguesas y papas fritas");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder5() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setWebsite("www.rodeoquilmes.com.ar")
                .createServiceInfo();

        assertEquals(anyServiceInfo.getWebsite(), "www.rodeoquilmes.com.ar");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder6() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setEMail("rodeoquilmes01@gmail.com")
                .createServiceInfo();

        assertEquals(anyServiceInfo.geteMail(), "rodeoquilmes01@gmail.com");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder7() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setPhoneNumber(42501324)
                .createServiceInfo();

        assertEquals(anyServiceInfo.getPhoneNumber(), 42501324,0);
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceProfileWithServiceProfileBuilder() {
        List<Menu> menus = new ArrayList<>();
        ServiceProfile anyServiceProfile = anyServiceProfile()
                .setMenus(menus)
                .setBalance(new Balance(0))
                .createServiceProfile();

        assertEquals(anyServiceProfile.getMenus().size(), 0);
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceProfileWithServiceProfileBuilder2() {
        ServiceProfile anyServiceProfile = anyServiceProfile()
                .setBalance(new Balance(0))
                .createServiceProfile();

        assertEquals(anyServiceProfile.getBalance().getAmount(),0,0 );
    }

}
