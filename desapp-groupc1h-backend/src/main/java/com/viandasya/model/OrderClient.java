package com.viandasya.model;

import java.time.LocalDate;

public class OrderClient extends AbstractOrder {
    public OrderClient(OrderState state, LocalDate orderDate, Integer score, Menu menu, Integer price, Integer amount) {
        super(state, orderDate, score, menu, price, amount);
    }

    public OrderClient() {
    }
}
