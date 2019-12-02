package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Offer;
import com.viandasya.model.menu.PriceHandler;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static com.viandasya.model.builders.menu.PriceHandlerBuilder.anyPriceHandler;

public class PriceHandlerBuilderTest {

    @Test
    public void testSetCurrentSetedInBuilderEqualsToTheOneGettedInPriceHandler() {
        Offer mockOffer = Mockito.mock(Offer.class);
        PriceHandler priceHandler = anyPriceHandler().setCurrent(mockOffer).createPriceHandler();

        Assert.assertEquals(mockOffer, priceHandler.getCurrent());
    }

    @Test
    public void testSetOffersSetedInBuilderEqualsToTheOneGettedInPriceHandler() {
        Offer current = Mockito.mock(Offer.class);
        List<Offer> offers = new ArrayList<>();
        offers.add(Mockito.mock(Offer.class));
        offers.add(Mockito.mock(Offer.class));

        PriceHandler priceHandler = anyPriceHandler().setCurrent(current)
                .setOffers(offers).createPriceHandler();
        offers.add(current);

        Assert.assertEquals(offers, priceHandler.getOffers());
    }
}