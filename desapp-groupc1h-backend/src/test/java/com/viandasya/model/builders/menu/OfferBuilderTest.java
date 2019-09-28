package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Offer;
import org.junit.Assert;
import org.junit.Test;

import static com.viandasya.model.builders.menu.OfferBuilder.anyOffer;

public class OfferBuilderTest {

    @Test
    public void setMinAmountSetedInBuilderEqualsToTheOneGettedInOffer() {
        Offer offer = anyOffer().setMinAmount(12).createOffer();

        Assert.assertEquals(12, offer.getMinAmount(), 0.0);
    }

    @Test
    public void setPriceSetedInBuilderEqualsToTheOneGettedInOffer() {
        Offer offer = anyOffer().setPrice(200).createOffer();

        Assert.assertEquals(200, offer.getPrice(), 0.0);
    }
}