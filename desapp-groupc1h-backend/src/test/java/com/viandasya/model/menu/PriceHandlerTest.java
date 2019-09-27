package com.viandasya.model.menu;

import org.junit.Assert;
import org.junit.Test;

import static com.viandasya.model.builders.menu.PriceHandlerBuilder.anyPriceHandler;

public class PriceHandlerTest {

    @Test
    public void testGetCurrentPriceWith10OrderCountPriceHandlerWithNoNextReturns20() {
        PriceHandler priceHandler = anyPriceHandler()
                .setOffer(new Offer(0,100))
                .createPriceHandler();

        Assert.assertEquals(100, priceHandler.getCurrentPrice(10), 0.0);
    }

    @Test
    public void testGetCurrentPriceWith10OrderCountPriceHandlerWithNextReturns30() {
        PriceHandler nextPriceHandler = anyPriceHandler()
                .setOffer(new Offer(15,170))
                .createPriceHandler();

        PriceHandler priceHandler = anyPriceHandler()
                .setOffer(new Offer(0,200))
                .setNext(nextPriceHandler)
                .createPriceHandler();

        Assert.assertEquals(170, priceHandler.getCurrentPrice(20), 0.0);
    }

}