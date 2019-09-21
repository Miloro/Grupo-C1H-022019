package com.viandasya.model;

public class Discount {
    private Integer minAmount;
    private Integer minAmountPrice;

    public Discount(Integer minAmount, Integer minAmountPrice) {
        this.minAmount = minAmount;
        this.minAmountPrice = minAmountPrice;
    }

    public Discount() {
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getMinAmountPrice() {
        return minAmountPrice;
    }

    public void setMinAmountPrice(Integer minAmountPrice) {
        this.minAmountPrice = minAmountPrice;
    }
}
