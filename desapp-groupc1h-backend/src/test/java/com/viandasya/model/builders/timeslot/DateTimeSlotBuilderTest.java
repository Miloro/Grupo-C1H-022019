package com.viandasya.model.builders.timeslot;

import com.viandasya.model.timeslot.DateTimeSlot;
import org.junit.Test;

import java.time.LocalDateTime;

import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static org.junit.Assert.assertTrue;

public class DateTimeSlotBuilderTest {

    @Test
    public void testIsValid_WhenICanCreateADateTimeSlotWithDateTimeSlotBuilder() {
        DateTimeSlot anyDateTimeSlot  = anyDateTimeSlot()
                .setSince(LocalDateTime.now().minusDays(12))
                .setFrom(LocalDateTime.now().minusDays(7))
                .createDateTimeSlot();

        assertTrue(anyDateTimeSlot.getSince().isBefore(anyDateTimeSlot.getFrom()));
    }

}
