package com.viandasya.model.menu;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class Offer {
    private Integer minAmount;
    private BigDecimal price;

    public Offer(Integer minAmount, BigDecimal price) {
        this.minAmount = minAmount;
        this.price = price;
    }

    public Offer() {
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return getMinAmount().equals(offer.getMinAmount()) &&
                getPrice().equals(offer.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMinAmount(), getPrice());
    }

    public boolean isPriceLessThan(Offer offer) {
        return price.compareTo(offer.getPrice()) < 0;
    }
}
