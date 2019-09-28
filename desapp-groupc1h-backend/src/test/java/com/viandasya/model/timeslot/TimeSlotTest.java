package com.viandasya.model.timeslot;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.timeslot.DayTimeSlotBuilder.anyDayTimeSlot;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class TimeSlotTest {

    @Test
    public void testIsValidDateTheDateIsBetweenTwoLocalDateTimes() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot()
                .setSince(LocalDateTime.now().minusDays(3))
                .setFrom(LocalDateTime.now().minusDays(2))
                .createDateTimeSlot();

        LocalDateTime date = LocalDateTime.now().minusDays(3).plusHours(4);

        Assert.assertTrue(dateTimeSlot.isValidDate(date));
    }

    @Test
    public void testIsValidDateTheDateIsNotBetweenTwoLocalDateTimes() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot()
                .setSince(LocalDateTime.now().minusDays(3))
                .setFrom(LocalDateTime.now().minusDays(2))
                .createDateTimeSlot();

        LocalDateTime date = LocalDateTime.now().minusDays(6);

        Assert.assertFalse(dateTimeSlot.isValidDate(date));
    }

    @Test
    public void testIsValidDateTheDateIsBetweenTheDayTimeSlot() {
        DayTimeSlot dayTimeSlot = anyDayTimeSlot()
                .setDay(DayOfWeek.THURSDAY)
                .setHoursTimeSlots(this.getMockedHourTimeSlots())
                .createDayTimeSlot();

        Assert.assertTrue(dayTimeSlot.isValidDate(LocalDateTime.of(2019,9,26,9,0)));
    }

    @Test
    public void testIsValidDateTheDateIsNotBetweenTheDayTimeSlot() {
        DayTimeSlot dayTimeSlot = anyDayTimeSlot()
                .setDay(DayOfWeek.MONDAY)
                .setHoursTimeSlots(this.getMockedHourTimeSlots())
                .createDayTimeSlot();

        Assert.assertFalse(dayTimeSlot.isValidDate(LocalDateTime.of(2019,9,26,9,0)));
    }

    private List<HoursTimeSlot> getMockedHourTimeSlots() {
        HoursTimeSlot hoursTimeSlot1 = Mockito.mock(HoursTimeSlot.class);
        HoursTimeSlot hoursTimeSlot2 = Mockito.mock(HoursTimeSlot.class);
        Mockito.when(hoursTimeSlot1.isValidDate(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(hoursTimeSlot2.isValidDate(ArgumentMatchers.any())).thenReturn(false);

        return Arrays.asList(hoursTimeSlot1, hoursTimeSlot2);
    }

    @Test
    public void testIsValidDateTheDateIsBetweenTheHourTimeSlot() {
        HoursTimeSlot hoursTimeSlot = new HoursTimeSlot(LocalTime.of(12,30), LocalTime.of(17,30));

        Assert.assertTrue(hoursTimeSlot.isValidDate(LocalDateTime.of(2019,10,2,17,12)));
    }

    @Test
    public void testIsValidDateTheDateIsNotBetweenTheHourTimeSlot() {
        HoursTimeSlot hoursTimeSlot = new HoursTimeSlot(LocalTime.of(12,30), LocalTime.of(17,30));

        Assert.assertFalse(hoursTimeSlot.isValidDate(LocalDateTime.of(2019,10,2,9,0)));
    }

    @Test
    public void testIsValidDateTheDateIsBetweenAnyTimeSlotInTheTimeTable() {
        TimeSlot mockTimeSlot1 = Mockito.mock(TimeSlot.class);
        TimeSlot mockTimeSlot2 = Mockito.mock(TimeSlot.class);
        Mockito.when(mockTimeSlot1.isValidDate(ArgumentMatchers.any())).thenReturn(true);
        Mockito.when(mockTimeSlot2.isValidDate(ArgumentMatchers.any())).thenReturn(false);

        TimeTable timetable =  new TimeTable(Arrays.asList(mockTimeSlot1, mockTimeSlot2));

        Assert.assertTrue(timetable.isValidDate(LocalDateTime.now()));
    }

    @Test
    public void testIsValidDateTheDateIsNotBetweenAnyTimeSlotInTheTimeTable() {
        TimeSlot mockTimeSlot1 = Mockito.mock(TimeSlot.class);
        TimeSlot mockTimeSlot2 = Mockito.mock(TimeSlot.class);
        Mockito.when(mockTimeSlot1.isValidDate(ArgumentMatchers.any())).thenReturn(false);
        Mockito.when(mockTimeSlot2.isValidDate(ArgumentMatchers.any())).thenReturn(false);

        TimeTable timetable =  new TimeTable(Arrays.asList(mockTimeSlot1, mockTimeSlot2));

        Assert.assertFalse(timetable.isValidDate(LocalDateTime.now()));
    }


}