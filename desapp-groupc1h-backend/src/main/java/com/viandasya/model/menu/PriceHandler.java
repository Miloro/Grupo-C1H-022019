package com.viandasya.model.menu;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.OrderBy;
import java.util.ArrayList;
import java.util.Comparator;
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

    public boolean updateCurrent(int orderCount) {
        return this.offers.stream()
                .filter(offer -> offer.getMinAmount() <= orderCount)
                .max(Comparator.comparing(Offer::getMinAmount))
                .map(offer -> {
                        if (!current.equals(offer)) {
                            this.current = offer;
                        }
                        return !current.equals(offer);
                }).get();
    }

}
