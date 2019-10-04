package com.viandasya.model.builders.timeslot;

import com.viandasya.model.timeslot.DayTimeSlot;
import com.viandasya.model.timeslot.HoursTimeSlot;
import com.viandasya.model.timeslot.TimeTable;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TimeTableBuilder {
    private List<DayTimeSlot> dayTimeSlots = Arrays.asList(
            new DayTimeSlot(DayOfWeek.MONDAY,
                    Collections.singletonList(new HoursTimeSlot(LocalTime.of(9, 0),
                            LocalTime.of(5, 0))), null),
            new DayTimeSlot(DayOfWeek.THURSDAY,
                    Collections.singletonList(new HoursTimeSlot(LocalTime.of(9, 0),
                            LocalTime.of(5, 0))), null)
    );

    public static TimeTableBuilder anyTimeTable() {
        return new TimeTableBuilder();
    }

    public TimeTableBuilder setDayTimeSlots(List<DayTimeSlot> dayTimeSlots) {
        this.dayTimeSlots = dayTimeSlots;
        return this;
    }

    public TimeTable createTimeTable() {
        return new TimeTable(dayTimeSlots);
    }
}