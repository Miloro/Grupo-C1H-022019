package com.viandasya.model.builders.timeslot;

import com.viandasya.model.timeslot.DayTimeSlot;
import com.viandasya.model.timeslot.HoursTimeSlot;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class DayTimeSlotBuilder {
    private DayOfWeek day = DayOfWeek.MONDAY;
    private List<HoursTimeSlot> hoursTimeSlots = Collections.singletonList(new HoursTimeSlot(LocalTime.NOON, LocalTime.MIDNIGHT));

    public static DayTimeSlotBuilder anyDayTimeSlot() {
        return new DayTimeSlotBuilder();
    }

    public DayTimeSlotBuilder setDay(DayOfWeek day) {
        this.day = day;
        return this;
    }

    public DayTimeSlotBuilder setHoursTimeSlots(List<HoursTimeSlot> hoursTimeSlots) {
        this.hoursTimeSlots = hoursTimeSlots;
        return this;
    }

    public DayTimeSlot createDayTimeSlot() {
        return new DayTimeSlot(day, hoursTimeSlots);
    }
}