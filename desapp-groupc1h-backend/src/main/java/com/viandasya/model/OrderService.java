package com.viandasya.model;

import java.time.LocalDate;

public class OrderService extends AbstractOrder {
    private LocalDate deliveryDate;
    private Boolean isDelivery;

    public OrderService(OrderState state, LocalDate orderDate, Integer score, Menu menu, Integer price, Integer amount, LocalDate deliveryDate, Boolean isDelivery) {
        super(state, orderDate, score, menu, price, amount);
        this.deliveryDate = deliveryDate;
        this.isDelivery = isDelivery;
    }

    public OrderService() {
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Boolean getDelivery() {
        return isDelivery;
    }

    public void setDelivery(Boolean delivery) {
        isDelivery = delivery;
    }
}
