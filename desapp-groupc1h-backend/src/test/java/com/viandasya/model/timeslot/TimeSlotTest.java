package com.viandasya.model.timeslot;

import org.junit.Test;

import static com.viandasya.model.builders.DateTimeSlotBuilder.anyDateTimeSlot;
import static org.junit.Assert.*;

import java.time.LocalDateTime;

public class TimeSlotTest {

    @Test
    public void testIsValidDate_theDateIsBetweenTwoLocalDateTimes() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot()
                .setSince(LocalDateTime.now().minusDays(3))
                .setFrom(LocalDateTime.now().minusDays(2))
                .createDateTimeSlot();

        LocalDateTime date = LocalDateTime.now().minusDays(3).plusHours(4);

        assertTrue(dateTimeSlot.isValidDate(date));
    }

    @Test
    public void testIsValidDate_theDateIsNotBetweenTwoLocalDateTimes() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot()
                .setSince(LocalDateTime.now().minusDays(3))
                .setFrom(LocalDateTime.now().minusDays(2))
                .createDateTimeSlot();

        LocalDateTime date = LocalDateTime.now().minusDays(6);

        assertFalse(dateTimeSlot.isValidDate(date));
    }

}