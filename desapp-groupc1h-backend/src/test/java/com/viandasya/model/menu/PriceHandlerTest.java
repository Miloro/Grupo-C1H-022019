package com.viandasya.model.menu;

import com.viandasya.exceptions.InvalidOffersException;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;

import static com.viandasya.model.builders.menu.OfferBuilder.anyOffer;
import static com.viandasya.model.builders.menu.PriceHandlerBuilder.anyPriceHandler;

public class PriceHandlerTest {

    @Test
    public void testSetOffersWhenAllTheOffersHaveAPriceLessThanThePreviousOneTheyAreSettedAsAnOrderedListByMinAmount() {
        List<Offer> offers = getOffers();
        Offer current = anyOffer().setPrice("200").setMinAmount(0).createOffer();
        PriceHandler priceHandler = anyPriceHandler().setCurrent(current).setOffers(offers).createPriceHandler();

        List<Offer> orderedOffers = new ArrayList<>(offers);
        orderedOffers.add(current);
        orderedOffers.sort(Comparator.comparingInt(Offer::getMinAmount));

        Assert.assertEquals(orderedOffers, priceHandler.getOffers());

    }

    private List<Offer> getOffers() {
        List<Offer> offers = new ArrayList<>();
        offers.add(anyOffer().setPrice("150").setMinAmount(101).createOffer());
        offers.add(anyOffer().setPrice("175").setMinAmount(40).createOffer());
        offers.add(anyOffer().setPrice("190").setMinAmount(12).createOffer());
        return offers;
    }

    @Test(expected = InvalidOffersException.class)
    public void testSetOffersWhenOneOfTheOffersDoesntHaveAPriceLessThanThePreviousOneThrowsInvalidOffersException() {
        List<Offer> offers = new ArrayList<>();
        offers.add(anyOffer().setPrice("175").setMinAmount(40).createOffer());
        offers.add(anyOffer().setPrice("50").setMinAmount(12).createOffer());
        Offer current = anyOffer().setPrice("100").setMinAmount(0).createOffer();

        anyPriceHandler().setCurrent(current).setOffers(offers).createPriceHandler();
    }


    @Test
    public void testUpdateCurrentWhenOrderCountIsMoreThanTheCurrentOfferANewCurrentOfferIsChosen() {
        List<Offer> offers = getOffers();
        Offer current = anyOffer().setPrice("200").setMinAmount(0).createOffer();
        PriceHandler priceHandler = anyPriceHandler().setCurrent(current).setOffers(offers).createPriceHandler();

        priceHandler.updateCurrent(41);
        Assert.assertEquals(offers.get(1), priceHandler.getCurrent());
    }

}