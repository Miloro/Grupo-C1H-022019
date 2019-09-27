package com.viandasya.model.builders;


import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import org.junit.Test;

import static org.junit.Assert.*;

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



}
