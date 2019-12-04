package com.viandasya.model.order;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static com.viandasya.model.builders.OrderBuilder.anyOrder;

public class OrderTest {

    @Test
    public void calculatePriceWithADeliveryPriceOf20Amount4AndOfferWithPrice210with32ItReturn861With28() {
        Order order = anyOrder().setIsDelivery(true).setAmount(4).createOrder();
        Assert.assertEquals(new BigDecimal("861.28"), order.calculatePrice());
    }

}