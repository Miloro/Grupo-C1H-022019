package com.viandasya.model.menu;

import com.viandasya.model.timeslot.DateTimeSlot;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.viandasya.model.builders.OrderBuilder.anyOrder;
import static com.viandasya.model.builders.menu.MenuBuilder.anyMenu;
import static com.viandasya.model.builders.menu.OfferBuilder.anyOffer;

public class MenuTest {

    @Test
    public void testIsValidCurrentDateIsBetweenValidityRange() {
        DateTimeSlot mockDateTimeSlot = Mockito.mock(DateTimeSlot.class);
        Mockito.when(mockDateTimeSlot.isValidDate(ArgumentMatchers.any(LocalDateTime.class))).thenReturn(true);

        Menu menu = anyMenu().setValidity(mockDateTimeSlot).createMenu();

        Assert.assertTrue(menu.isValid());
    }

    @Test
    public void testIsValidCurrentDateIsNotBetweenValidityRange() {
        DateTimeSlot mockDateTimeSlot = Mockito.mock(DateTimeSlot.class);
        Mockito.when(mockDateTimeSlot.isValidDate(ArgumentMatchers.any(LocalDateTime.class))).thenReturn(false);

        Menu menu = anyMenu().setValidity(mockDateTimeSlot).createMenu();

        Assert.assertFalse(menu.isValid());
    }

    @Test
    public void testCurrentPriceMenuWith10OrderCountReturn100() {
        List<Offer> offers = new ArrayList<>();
        offers.add(anyOffer().setPrice(new BigDecimal("175")).setMinAmount(25).createOffer());
        offers.add(anyOffer().setPrice(new BigDecimal("180")).setMinAmount(20).createOffer());
        offers.add(anyOffer().setPrice(new BigDecimal("200")).setMinAmount(0).createOffer());

        Menu menu = anyMenu()
                .setOrders(Arrays.asList(anyOrder().setAmount(10).createOrder(),
                        anyOrder().setAmount(11).createOrder()))
                .setOffers(offers).createMenu();

        Assert.assertEquals(new BigDecimal("180"), menu.getCurrentPrice());
    }

}