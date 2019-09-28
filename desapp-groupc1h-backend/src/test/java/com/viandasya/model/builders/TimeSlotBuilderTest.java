package com.viandasya.model.builders;

import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.DayTimeSlot;
import com.viandasya.model.timeslot.HoursTimeSlot;
import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.timeslot.DayTimeSlotBuilder.anyDayTimeSlot;

public class TimeSlotBuilderTest {

    @Test
    public void setSinceSetedInBuilderEqualsToTheOneGettedInDateTimeSlot() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot()
                .setSince(LocalDateTime.of(2018,2,12,3,15))
                .createDateTimeSlot();

        Assert.assertEquals(LocalDateTime.of(2018,2,12,3,15),
                dateTimeSlot.getSince());
    }

    @Test
    public void setFromSetedInBuilderEqualsToTheOneGettedInDateTimeSlot() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot()
                .setFrom(LocalDateTime.of(2015,1,6,4,46))
                .createDateTimeSlot();

        Assert.assertEquals(LocalDateTime.of(2015,1,6,4,46),
                dateTimeSlot.getFrom());
    }

    @Test
    public void setDaySetedInBuilderEqualsToTheOneGettedInDayTimeSlot() {
        DayTimeSlot dayTimeSlot = anyDayTimeSlot().setDay(DayOfWeek.SATURDAY).createDayTimeSlot();

        Assert.assertEquals(DayOfWeek.SATURDAY, dayTimeSlot.getDay());
    }

    @Test
    public void setHoursTimeSlotSetedInBuilderEqualsToTheOneGettedInDayTimeSlot() {
        List<HoursTimeSlot> hoursTimeSlots = new ArrayList<>();
        hoursTimeSlots.add(new HoursTimeSlot(LocalTime.NOON, LocalTime.MIDNIGHT));
        hoursTimeSlots.add(new HoursTimeSlot(LocalTime.of(8,0), LocalTime.of(10,0)));

        DayTimeSlot dayTimeSlot = anyDayTimeSlot()
                .setHoursTimeSlots(hoursTimeSlots)
                .createDayTimeSlot();

        Assert.assertEquals(hoursTimeSlots, dayTimeSlot.getHoursTimeSlots());
    }

}