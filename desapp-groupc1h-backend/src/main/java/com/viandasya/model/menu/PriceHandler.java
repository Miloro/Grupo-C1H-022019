package com.viandasya.model.menu;

import com.viandasya.exceptions.InvalidOffersException;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
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

    public void setOffers(List<Offer> offers) {
        this.validateOffers(offers);
        this.offers = offers;
    }

    private void validateOffers(List<Offer> offers) {
        boolean areValid = true;
        offers.sort(Comparator.comparingInt(Offer::getMinAmount));
        for (int i = 1; i < offers.size(); i++) {
            areValid = areValid && offers.get(i).isPriceLessThan(offers.get(i - 1));
        }
        if (!areValid) throw new InvalidOffersException();
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
