package com.viandasya.model;

import java.time.LocalDateTime;

public class OrderMenu extends AbstractOrder {
    private LocalDateTime deliveryDate;
    private Boolean isDelivery;

    public OrderMenu(OrderState state, LocalDateTime orderDate, Integer score, Integer price, Integer amount, LocalDateTime deliveryDate, Boolean isDelivery) {
        super(state, orderDate, score, price, amount);
        this.deliveryDate = deliveryDate;
        this.isDelivery = isDelivery;
    }

    public OrderMenu() {
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Boolean getDelivery() {
        return isDelivery;
    }

    public void setDelivery(Boolean delivery) {
        isDelivery = delivery;
    }
}
