package com.viandasya.model.menu;

public class Offer {
    private Integer minAmount;
    private Integer price;

    public Offer(Integer minAmount, Integer price) {
        this.minAmount = minAmount;
        this.price = price;
    }

    public Offer() {
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
