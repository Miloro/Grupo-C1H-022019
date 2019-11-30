package com.viandasya.model.builders;

import com.viandasya.model.order.OrderState;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.order.Order;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.user.ClientProfile;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.viandasya.model.builders.OrderBuilder.anyOrder;
import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.*;


public class OrderBuilderTest {

    @Test
    public void testIsValidWhenICanCreateAOrderWithOrderBuilder() {
        Order anyOrder = new OrderBuilder()
                .setAmount(1234)
                .createOrder();

        Assert.assertEquals(anyOrder.getAmount(), 1234, 0);
    }

    @Test
    public void testIsValidWhenICanCreateAOrderWithOrderBuilder2() {
        Order anyOrder = new OrderBuilder()
                .setScore(2)
                .createOrder();

        Assert.assertEquals(anyOrder.getScore(), 2,0);
    }

    @Test
    public void testIsValidWhenICanCreateAOrderWithOrderBuilder3() {
        Order anyOrder = new OrderBuilder()
                .setState(OrderState.CONFIRMED)
                .createOrder();

        Assert.assertEquals(anyOrder.getState(), OrderState.CONFIRMED);
    }

    @Test
    public void testIsValidWhenICanCreateAOrderWithOrderBuilder4() {
        Order anyOrder = new OrderBuilder()
                .setIsDelivery(false)
                .createOrder();

        Assert.assertEquals(anyOrder.getDelivery(), false);
    }

    @Test
    public void testSetOrderDateSetedInBuilderEqualsToTheOneGettedInOrder() {
        DateTimeSlot date = anyDateTimeSlot()
                .setFrom(LocalDateTime.of(2019,9,20,12,0))
                .setTo(LocalDateTime.of(2019,9,20,13,0))
                .createDateTimeSlot();
        Order order = anyOrder().setOrderDate(date).createOrder();

        Assert.assertEquals(date, order.getOrderDate());
    }

    @Test
    public void testSetClientSetedInBuilderEqualsToTheOneGettedInOrder() {
        ClientProfile client = Mockito.mock(ClientProfile.class);
        Order order = anyOrder().setClient(client).createOrder();

        Assert.assertEquals(client, order.getClient());
    }

    @Test
    public void testSetMenuSetedInBuilderEqualsToTheOneGettedInOrder() {
        Menu menu = Mockito.mock(Menu.class);
        Order order = anyOrder().setMenu(menu).createOrder();

        Assert.assertEquals(menu, order.getMenu());
    }

    @Test
    public void testSetOfferSetedInBuilderEqualsToTheOneGettedInOrder() {
        Offer offer = Mockito.mock(Offer.class);
        Order order = anyOrder().setOffer(offer).createOrder();

        Assert.assertEquals(offer, order.getOffer());
    }
}




