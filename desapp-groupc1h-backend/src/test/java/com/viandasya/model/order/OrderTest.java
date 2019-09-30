package com.viandasya.model.order;

import com.viandasya.model.menu.Offer;
import com.viandasya.model.builders.menu.OfferBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.viandasya.model.builders.OrderBuilder.anyOrder;

public class OrderTest {

    @Test
    public void testGetCurrentPriceAnOrderWithOffersOfPrices100And170Returns100() {
        List<Offer> offers = Arrays.asList(new OfferBuilder().setMinAmount(0).setPrice(new BigDecimal("170")).createOffer(),
                                           new OfferBuilder().setMinAmount(30).setPrice(new BigDecimal("100")).createOffer());
        Order order = anyOrder().setOffers(offers).createOrder();

        Assert.assertEquals(new BigDecimal("100"), order.getCurrentPrice());
    }
}