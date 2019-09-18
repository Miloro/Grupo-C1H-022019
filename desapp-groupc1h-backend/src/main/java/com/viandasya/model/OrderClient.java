package com.viandasya.model;

import java.time.LocalDateTime;

public class OrderClient extends AbstractOrder {
    private Menu menu;

    public OrderClient(OrderState state, LocalDateTime orderDate, Integer score, Integer price, Integer amount, Menu menu) {
        super(state, orderDate, score, price, amount);
        this.menu = menu;
    }

    public OrderClient() {
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
