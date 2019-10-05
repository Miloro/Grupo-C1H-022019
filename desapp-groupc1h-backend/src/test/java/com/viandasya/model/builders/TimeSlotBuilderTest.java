package com.viandasya.model.builders;

import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.DayTimeSlot;
import com.viandasya.model.timeslot.TimeTable;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.timeslot.TimeTableBuilder.anyTimeTable;

public class TimeSlotBuilderTest {

    @Test
    public void testSetSinceSetedInBuilderEqualsToTheOneGettedInDateTimeSlot() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot()
                .setSince(LocalDateTime.of(2018,2,12,3,15))
                .createDateTimeSlot();

        Assert.assertEquals(LocalDateTime.of(2018,2,12,3,15),
                dateTimeSlot.getSince());
    }

    @Test
    public void testSetFromSetedInBuilderEqualsToTheOneGettedInDateTimeSlot() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot()
                .setFrom(LocalDateTime.of(2015,1,6,4,46))
                .createDateTimeSlot();

        Assert.assertEquals(LocalDateTime.of(2015,1,6,4,46),
                dateTimeSlot.getUntil());
    }

    @Test
    public void testSetDayTimeSlotsSetedInBuilderEqualsToTheOneGettedInTimeTable() {
        List<DayTimeSlot> dayTimeSlots = new ArrayList<>();
        TimeTable timeTable = anyTimeTable().setDayTimeSlots(dayTimeSlots).createTimeTable();

        Assert.assertEquals(dayTimeSlots, timeTable.getDayTimeSlots());
    }

}