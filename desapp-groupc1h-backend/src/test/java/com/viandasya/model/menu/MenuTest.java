package com.viandasya.model.menu;

import com.viandasya.model.timeslot.DateTimeSlot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static com.viandasya.model.builders.MenuBuilder.anyMenu;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Test
    public void testIsValid_currentDateIsBetweenValidityRange() {
        DateTimeSlot mockDateTimeSlot = mock(DateTimeSlot.class);
        when(mockDateTimeSlot.isValidDate(ArgumentMatchers.any(LocalDateTime.class))).thenReturn(true);

        Menu menu = anyMenu().setValidity(mockDateTimeSlot).createMenu();

        assertTrue(menu.isValid());
    }

    @Test
    public void testIsValid_currentDateIsNotBetweenValidityRange() {
        DateTimeSlot mockDateTimeSlot = mock(DateTimeSlot.class);
        when(mockDateTimeSlot.isValidDate(ArgumentMatchers.any(LocalDateTime.class))).thenReturn(false);

        Menu menu = anyMenu().setValidity(mockDateTimeSlot).createMenu();

        assertFalse(menu.isValid());
    }
}