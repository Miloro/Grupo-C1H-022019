package com.viandasya.model.order;

import com.viandasya.model.menu.Offer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.viandasya.model.builders.OrderBuilder.anyOrder;

public class OrderTest {

    @Test
    public void testGetCurrentPriceAnOrderWithOffersOfPrices100And170Returns100() {
        List<Offer> offers = Arrays.asList(new Offer(0,170), new Offer(30,100));
        Order order = anyOrder().setOffers(offers).createOrder();

        Assert.assertEquals(100, order.getCurrentPrice(), 0.0);
    }
}