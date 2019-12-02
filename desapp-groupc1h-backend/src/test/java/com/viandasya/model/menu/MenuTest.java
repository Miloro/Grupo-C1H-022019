package com.viandasya.model.menu;

import com.viandasya.model.timeslot.DateTimeSlot;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static com.viandasya.model.builders.menu.MenuBuilder.anyMenu;

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
    public void testGetCurrentOfferReturnCurrentOfferFromPriceHandler() {
        PriceHandler mockPriceHandler = Mockito.mock(PriceHandler.class);
        Mockito.when(mockPriceHandler.getCurrent()).thenReturn(Mockito.mock(Offer.class));

        Menu menu = anyMenu().setPriceHandler(mockPriceHandler).createMenu();

        Assert.assertEquals(mockPriceHandler.getCurrent(), menu.getCurrentOffer());
    }

}
