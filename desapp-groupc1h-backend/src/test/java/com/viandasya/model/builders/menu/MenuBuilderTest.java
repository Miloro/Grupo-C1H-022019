package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.order.Order;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.viandasya.model.builders.menu.MenuBuilder.anyMenu;
import static com.viandasya.model.builders.menu.OfferBuilder.anyOffer;

import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.DayTimeSlot;
import org.junit.Assert;

import java.time.DayOfWeek;

import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.timeslot.DayTimeSlotBuilder.anyDayTimeSlot;

public class MenuBuilderTest {

    @Test
    public void testIsValidWhenICanCreateAMenuWithMenuBuilder() {
        Menu anyMenu = anyMenu()
                .setName("aaaaa")
                .createMenu();

        Assert.assertEquals(anyMenu.getName(),"aaaaa");
    }

    @Test
    public void testIsValidWhenICanCreateAMenuWithMenuBuilder2() {
        Menu anyMenu = anyMenu()
                .setDescription("aaaaaaaaaaaaaaaaaaaaaaa")
                .createMenu();

        Assert.assertEquals(anyMenu.getDescription(),"aaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test
    public void testIsValidWhenICanCreateAMenuWithMenuBuilder3() {
        Menu anyMenu = anyMenu()
                .setCategory(Collections.singletonList(Category.GREEN))
                .createMenu();

        Assert.assertEquals(anyMenu.getCategory().get(0),Category.GREEN);
    }

    @Test
    public void testIsValidWhenICanCreateAMenuWithMenuBuilder4() {
        Menu anyMenu = anyMenu()
                .setDeliveryPrice(30)
                .createMenu();

        Assert.assertEquals(anyMenu.getDeliveryPrice(),30,0);
    }


    @Test
    public void testIsValidWhenICanCreateAMenuWithMenuBuilder5() {
        Menu anyMenu = anyMenu()
                .setAverageDeliveryTime(48)
                .createMenu();

        Assert.assertEquals(anyMenu.getAverageDeliveryTime(),48,0);
    }

    @Test
    public void testIsValidWhenICanCreateAMenuWithMenuBuilder8() {
        Menu anyMenu = anyMenu()
                .setMaxAmountPerDay(33)
                .createMenu();

        Assert.assertEquals(anyMenu.getMaxAmountPerDay(),33,0);
    }

    @Test
    public void testIsValidWhenICanCreateAMenuWithMenuBuilder9() {
        List<Order> orders = new ArrayList<>();
        Menu anyMenu = anyMenu()
                .setOrders(orders)
                .createMenu();

        Assert.assertEquals(anyMenu.getOrders().size(),0);
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
    public void setOffersSetedInBuilderEqualsToTheOneGettedInMenu() {
        List<Offer> offers = new ArrayList<>();
        offers.add(anyOffer().createOffer());
        Menu menu = anyMenu().setOffers(offers).createMenu();

        Assert.assertEquals(offers, menu.getOffers());
    }
}
