package com.viandasya.model.menu;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class PriceHandler {
    private Offer current;

    @ElementCollection
    private List<Offer> offers = new ArrayList<>();

    public PriceHandler(Offer current) {
        this.current = current;
    }

    public PriceHandler() {
    }

    public Offer getCurrent() {
        return current;
    }

    public void setCurrent(Offer current) {
        this.current = current;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void addOffer(Offer offer) {
        this.offers.add(offer);
    }

}
