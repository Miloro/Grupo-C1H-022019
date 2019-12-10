package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Offer;
import com.viandasya.model.menu.PriceHandler;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static com.viandasya.model.builders.menu.OfferBuilder.anyOffer;
import static com.viandasya.model.builders.menu.PriceHandlerBuilder.anyPriceHandler;

public class PriceHandlerBuilderTest {

    @Test
    public void testSetCurrentSetedInBuilderEqualsToTheOneGettedInPriceHandler() {
        Offer current = anyOffer().setPrice("200").setMinAmount(0).createOffer();
        PriceHandler priceHandler = anyPriceHandler().setCurrent(current).createPriceHandler();

        Assert.assertEquals(current, priceHandler.getCurrent());
    }

    @Test
    public void testSetOffersSetedInBuilderEqualsToTheOneGettedInPriceHandler() {
        Offer current = anyOffer().setPrice("200").setMinAmount(0).createOffer();
        List<Offer> offers = new ArrayList<>();
        offers.add(anyOffer().setPrice("140").setMinAmount(20).createOffer());
        offers.add(anyOffer().setPrice("100").setMinAmount(30).createOffer());

        PriceHandler priceHandler = anyPriceHandler().setCurrent(current).setOffers(offers).createPriceHandler();
        offers.add(current);

        Assert.assertTrue(priceHandler.getOffers().containsAll(offers));
    }

}