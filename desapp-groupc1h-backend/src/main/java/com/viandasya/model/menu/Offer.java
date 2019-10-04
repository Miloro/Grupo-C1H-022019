package com.viandasya.model.menu;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

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
}
