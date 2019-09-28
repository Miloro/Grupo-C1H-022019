package com.viandasya.model.builders.timeslot;

import com.viandasya.model.timeslot.DayTimeSlot;
import org.junit.Test;

import java.time.DayOfWeek;

import static com.viandasya.model.builders.timeslot.DayTimeSlotBuilder.anyDayTimeSlot;
import static org.junit.Assert.assertEquals;

public class DayTimeSlotBuilderTest {
    @Test
    public void testIsValid_WhenICanCreateADayTimeSlotWithDayTimeSlotBuilder() {
        DayTimeSlot anyDateTimeSlot  =  anyDayTimeSlot()
                .setDay(DayOfWeek.MONDAY)
                .createDayTimeSlot();

        assertEquals(anyDateTimeSlot.getDay(),DayOfWeek.MONDAY);
    }
}
