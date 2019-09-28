package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.order.Order;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.viandasya.model.builders.menu.MenuBuilder.anyMenu;
import static org.junit.Assert.assertEquals;

import com.viandasya.model.menu.PriceHandler;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.DayTimeSlot;
import org.junit.Assert;

import java.time.DayOfWeek;

import static com.viandasya.model.builders.menu.PriceHandlerBuilder.anyPriceHandler;
import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.timeslot.DayTimeSlotBuilder.anyDayTimeSlot;

public class MenuBuilderTest {

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
    public void testSetDeliveryDaysSetedInBuilderEqualsToTheOneGettedInMenu() {
        DayTimeSlot dayTimeSlot = anyDayTimeSlot().setDay(DayOfWeek.FRIDAY).createDayTimeSlot();
        Menu menu = anyMenu().setDeliveryDays(dayTimeSlot).createMenu();

        Assert.assertEquals(dayTimeSlot, menu.getDeliveryDays());
    }

    @Test
    public void setValiditySetedInBuilderEqualsToTheOneGettedInMenu() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot().createDateTimeSlot();
        Menu menu = anyMenu().setValidity(dateTimeSlot).createMenu();

        Assert.assertEquals(dateTimeSlot, menu.getValidity());
    }

    @Test
    public void setPriceHandlerSetedInBuilderEqualsToTheOneGettedInMenu() {
        PriceHandler priceHandler = anyPriceHandler().createPriceHandler();
        Menu menu = anyMenu().setPriceHandler(priceHandler).createMenu();

        Assert.assertEquals(priceHandler, menu.getPriceHandler());
    }

}
