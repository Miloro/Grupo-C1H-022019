package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.DeliveryInfo;
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
import org.junit.Assert;
import org.mockito.Mockito;

import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;

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
                .setCategories(Collections.singletonList(Category.GREEN))
                .createMenu();

        Assert.assertEquals(anyMenu.getCategories().get(0),Category.GREEN);
    }


    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder8() {
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
    public void testSetValiditySetedInBuilderEqualsToTheOneGettedInMenu() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot().createDateTimeSlot();
        Menu menu = anyMenu().setValidity(dateTimeSlot).createMenu();

        Assert.assertEquals(dateTimeSlot, menu.getValidity());
    }


    @Test
    public void testSetDeliveryInfoSetedInBuilderEqualsToTheOneGettedInMenu() {
        DeliveryInfo deliveryInfo = Mockito.mock(DeliveryInfo.class);
        Menu menu = anyMenu().setDeliveryInfo(deliveryInfo).createMenu();

        Assert.assertEquals(deliveryInfo, menu.getDeliveryInfo());
    }
}
