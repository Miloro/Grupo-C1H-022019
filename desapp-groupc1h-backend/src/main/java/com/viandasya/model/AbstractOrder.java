package com.viandasya.model;

import java.time.LocalDate;

public abstract class AbstractOrder {
    private OrderState state;
    private LocalDate orderDate;
    private Integer score;
    private Menu menu;
    private Integer price;
    private Integer amount;

    public AbstractOrder(OrderState state, LocalDate orderDate, Integer score, Menu menu, Integer price, Integer amount) {
        this.state = state;
        this.orderDate = orderDate;
        this.score = score;
        this.menu = menu;
        this.price = price;
        this.amount = amount;
    }

    public AbstractOrder() {
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
