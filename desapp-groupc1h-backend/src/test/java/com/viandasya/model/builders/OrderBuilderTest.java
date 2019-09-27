package com.viandasya.model.builders;

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
    public void setOffersSetedInBuilderEqualsToTheOneGettedInOrder() {
        List<Offer> offers = new ArrayList<>();
        offers.add(Mockito.mock(Offer.class));
        offers.add(Mockito.mock(Offer.class));
        Order order = anyOrder().setOffers(offers).createOrder();

        Assert.assertEquals(offers, order.getOffers());
    }
}