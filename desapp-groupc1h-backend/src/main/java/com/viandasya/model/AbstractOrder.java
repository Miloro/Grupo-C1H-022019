package com.viandasya.model;

import java.time.LocalDateTime;

public abstract class AbstractOrder {
    private OrderState state;
    private LocalDateTime orderDate;
    private Integer score;
    private Integer price;
    private Integer amount;

    public AbstractOrder(OrderState state, LocalDateTime orderDate, Integer score, Integer price, Integer amount) {
        this.state = state;
        this.orderDate = orderDate;
        this.score = score;
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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
