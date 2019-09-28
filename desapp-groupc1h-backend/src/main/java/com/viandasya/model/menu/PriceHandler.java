package com.viandasya.model.menu;

public class PriceHandler {
    private Offer offer;
    private PriceHandler next;

    public PriceHandler(Offer offer, PriceHandler next) {
        this.offer = offer;
        this.next = next;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public PriceHandler getNext() {
        return next;
    }

    public void setNext(PriceHandler next) {
        this.next = next;
    }

    private PriceHandler getCurrentPriceHandler(int orderCount) {
        if (orderCount > this.offer.getMinAmount() && this.next != null) {
            return next.getCurrentPriceHandler(orderCount);
        }
        else {
            return this;
        }
    }

    public Integer getCurrentPrice(int orderCount) {
        return this.getCurrentPriceHandler(orderCount).getOffer().getPrice();
    }

}
