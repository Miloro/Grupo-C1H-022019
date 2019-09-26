package com.viandasya.model.menu;

import com.viandasya.model.order.Order;
import com.viandasya.model.timeslot.DateTimeSlot;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.viandasya.model.builders.MenuBuilder.anyMenu;

@RunWith(MockitoJUnitRunner.class)
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
        PriceHandler mockPriceHandler = Mockito.mock(PriceHandler.class);
        Mockito.when(mockPriceHandler.getCurrentPrice(10)).thenReturn(100);

        Menu menu = anyMenu()
                .setOrders(this.create10MockOrders())
                .setPriceHandler(mockPriceHandler).createMenu();

        Assert.assertEquals(100, menu.getCurrentPrice(), 0.0);
    }

    private List<Order> create10MockOrders() {
        Order mockOrder1 = Mockito.mock(Order.class);
        Order mockOrder2 = Mockito.mock(Order.class);

        Mockito.when(mockOrder1.getAmount()).thenReturn(5);
        Mockito.when(mockOrder2.getAmount()).thenReturn(5);

        return Arrays.asList(mockOrder1, mockOrder2);
    }

}