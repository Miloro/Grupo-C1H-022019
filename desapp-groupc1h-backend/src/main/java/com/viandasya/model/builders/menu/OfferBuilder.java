package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Offer;

public class OfferBuilder {
    private Integer minAmount;
    private Integer price;

    public static OfferBuilder anyOffer() {
        return new OfferBuilder();
    }

    public OfferBuilder setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
        return this;
    }

    public OfferBuilder setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Offer createOffer() {
        return new Offer(minAmount, price);
    }
}