package com.viandasya.model.builders;

import com.viandasya.model.menu.Offer;
import com.viandasya.model.menu.PriceHandler;

public class PriceHandlerBuilder {
    private Offer offer = new Offer(0,200);
    private PriceHandler next;

    public static PriceHandlerBuilder anyPriceHandler() {
        return new PriceHandlerBuilder();
    }

    public PriceHandlerBuilder setOffer(Offer offer) {
        this.offer = offer;
        return this;
    }

    public PriceHandlerBuilder setNext(PriceHandler next) {
        this.next = next;
        return this;
    }

    public PriceHandler createPriceHandler() {
        return new PriceHandler(offer, next);
    }
}