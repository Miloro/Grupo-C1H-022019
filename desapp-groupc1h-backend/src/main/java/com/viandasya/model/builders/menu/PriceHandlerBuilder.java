package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Offer;
import com.viandasya.model.menu.PriceHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.viandasya.model.builders.menu.OfferBuilder.anyOffer;

public class PriceHandlerBuilder {
    private Offer current = anyOffer().setPrice("200").setMinAmount(0).createOffer();
    private List<Offer> offers = Arrays.asList(
            anyOffer().setPrice("140").setMinAmount(20).createOffer(),
            anyOffer().setPrice("100").setMinAmount(30).createOffer());

    public static PriceHandlerBuilder anyPriceHandler() {
        return new PriceHandlerBuilder();
    }

    public PriceHandlerBuilder setCurrent(Offer current) {
        this.current = current;
        return this;
    }

    public PriceHandlerBuilder setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

    public PriceHandler createPriceHandler() {
        PriceHandler priceHandler = new PriceHandler(current);
        List<Offer> offers = new ArrayList<>(this.offers);
        offers.add(current);
        priceHandler.setOffers(offers);
        return priceHandler;
    }

}