package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Offer;

import java.math.BigDecimal;

public class OfferBuilder {
    private Integer minAmount = 12;
    private String price = "200";

    public static OfferBuilder anyOffer() {
        return new OfferBuilder();
    }

    public OfferBuilder setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
        return this;
    }

    public OfferBuilder setPrice(String price) {
        this.price = price;
        return this;
    }

    public Offer createOffer() {
        return new Offer(minAmount, new BigDecimal(price));
    }
}