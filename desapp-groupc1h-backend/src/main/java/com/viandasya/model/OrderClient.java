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

    public static class Builder{
        private OrderState state;
        private LocalDateTime orderDate;
        private Integer score;
        private Integer price;
        private Integer amount;
        private Menu menu;

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

        public Builder setMenu(Menu menu){
            this.menu = menu;
            return this;
        }

        public OrderClient build(){
            return new OrderClient(state, orderDate, score, price, amount, menu);
        }

    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
