package com.viandasya.model.builders.timeslot;

import com.viandasya.model.timeslot.DateTimeSlot;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;

public class DateTimeSlotBuilderTest {

    @Test
    public void testIsValid_WhenICanCreateADateTimeSlotWithDateTimeSlotBuilder() {
        DateTimeSlot anyDateTimeSlot  = anyDateTimeSlot()
                .setSince(LocalDateTime.now().minusDays(12))
                .setFrom(LocalDateTime.now().minusDays(7))
                .createDateTimeSlot();

        Assert.assertTrue(anyDateTimeSlot.getSince().isBefore(anyDateTimeSlot.getFrom()));
    }

}