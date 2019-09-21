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

    public static class Builder{
        private OrderState state;
        private LocalDateTime orderDate;
        private Integer score;
        private Integer price;
        private Integer amount;
        private LocalDateTime deliveryDate;
        private Boolean isDelivery;


        public Builder(){}

        public Builder setState(OrderState state){
            this.state = state;
            return this;
        }

        public Builder setOrderDate(LocalDateTime orderDate){
            this.orderDate = orderDate;
            return this;
        }

        public Builder setScore(Integer score){
            this.score = score;
            return this;
        }

        public Builder setPrice(Integer price){
            this.price = price;
            return this;
        }

        public Builder setAmount(Integer amount){
            this.amount = amount;
            return this;
        }

        public Builder setDeliveryDate(LocalDateTime deliveryDate){
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Builder setIsDelivery(Boolean isDelivery){
            this.isDelivery = isDelivery;
            return this;
        }

        public OrderMenu build(){
            return new OrderMenu(state, orderDate, score, price, amount, deliveryDate, isDelivery);
        }

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
