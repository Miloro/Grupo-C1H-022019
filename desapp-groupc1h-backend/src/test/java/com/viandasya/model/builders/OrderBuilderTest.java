package com.viandasya.model.builders;

import com.viandasya.model.order.OrderState;

import static org.junit.Assert.*;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.order.Order;
import com.viandasya.model.user.ClientProfile;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.viandasya.model.builders.OrderBuilder.anyOrder;


public class OrderBuilderTest {

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
    public void testSetOrderDateSetedInBuilderEqualsToTheOneGettedInOrder() {
        LocalDateTime date = LocalDateTime.of(2019,3,21,4,0);
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
    public void testSetOffersSetedInBuilderEqualsToTheOneGettedInOrder() {
        List<Offer> offers = new ArrayList<>();
        offers.add(Mockito.mock(Offer.class));
        offers.add(Mockito.mock(Offer.class));
        Order order = anyOrder().setOffers(offers).createOrder();

        Assert.assertEquals(offers, order.getOffers());
    }


}




