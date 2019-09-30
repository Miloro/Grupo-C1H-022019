package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Offer;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static com.viandasya.model.builders.menu.OfferBuilder.anyOffer;

public class OfferBuilderTest {

    @Test
    public void testSetMinAmountSetedInBuilderEqualsToTheOneGettedInOffer() {
        Offer offer = anyOffer().setMinAmount(12).createOffer();

        Assert.assertEquals(12, offer.getMinAmount(), 0.0);
    }

    @Test
    public void testSetPriceSetedInBuilderEqualsToTheOneGettedInOffer() {
        Offer offer = anyOffer().setPrice(new BigDecimal("200")).createOffer();

        Assert.assertEquals(new BigDecimal("200"), offer.getPrice());
    }
}