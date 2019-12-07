package com.viandasya.model.menu;

import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import com.viandasya.model.timeslot.DateTimeSlot;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testUpdateScoreIfMenuHasMoreThan20ConfirmedOrdersTheScoreIsUpdatedAndThenReturnsIfItWasUpdated() {
        List<Order> mockOrders = new ArrayList<>();
        Arrays.asList(4,3,5,4,5,1,4,5,2,1,3,4,5,2,4,3,1,5,3,4).forEach(integer -> {
            Order mockOrder = Mockito.mock(Order.class);
            Mockito.when(mockOrder.getState()).thenReturn(OrderState.CONFIRMED);
            Mockito.when(mockOrder.getScore()).thenReturn(integer);
            mockOrders.add(mockOrder);
        });

        Menu menu = anyMenu().setOrders(mockOrders).createMenu();
        menu.updateScore();

        Assert.assertEquals(3.4, menu.getScore(), 0);
    }

    @Test
    public void testUpdateScoreIfMenuHasLessThan20ConfirmedOrdersTheScoreIsNotUpdatedAndReturns0() {
        List<Order> mockOrders = new ArrayList<>();
        Arrays.asList(4,3,5,4,5,1,4,5,2,1,3,4,5,2,4,3,1).forEach(integer -> {
            Order mockOrder = Mockito.mock(Order.class);
            Mockito.when(mockOrder.getState()).thenReturn(OrderState.CONFIRMED);
            Mockito.when(mockOrder.getScore()).thenReturn(integer);
            mockOrders.add(mockOrder);
        });

        Menu menu = anyMenu().setOrders(mockOrders).createMenu();
        menu.updateScore();

        Assert.assertNull(menu.getScore());
    }
}
