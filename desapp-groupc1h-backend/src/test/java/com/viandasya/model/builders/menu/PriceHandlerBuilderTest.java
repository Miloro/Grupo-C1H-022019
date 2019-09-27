package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Offer;
import com.viandasya.model.menu.PriceHandler;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static com.viandasya.model.builders.menu.PriceHandlerBuilder.anyPriceHandler;

public class PriceHandlerBuilderTest {

    @Test
    public void setOfferOfferSetedInBuilderEqualsToTheOneGetted() {
        Offer offer = Mockito.mock(Offer.class);
        PriceHandler priceHandler = anyPriceHandler()
                .setOffer(offer)
                .createPriceHandler();

        Assert.assertEquals(offer, priceHandler.getOffer());
    }

    @Test
    public void setNextNextSetedInBuilderEqualsToTheOneGetted() {
        PriceHandler nextPriceHandler = Mockito.mock(PriceHandler.class);

        PriceHandler priceHandler = anyPriceHandler()
                .setNext(nextPriceHandler)
                .createPriceHandler();

        Assert.assertEquals(nextPriceHandler, priceHandler.getNext());
    }
}