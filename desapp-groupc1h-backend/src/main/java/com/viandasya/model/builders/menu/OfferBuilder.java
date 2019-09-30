package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Offer;

import java.math.BigDecimal;

public class OfferBuilder {
    private Integer minAmount;
    private BigDecimal price;

    public static OfferBuilder anyOffer() {
        return new OfferBuilder();
    }

    public OfferBuilder setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
        return this;
    }

    public OfferBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Offer createOffer() {
        return new Offer(minAmount, price);
    }
}