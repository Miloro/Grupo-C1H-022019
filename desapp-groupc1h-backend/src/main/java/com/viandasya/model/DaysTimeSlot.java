package com.viandasya.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class DaysTimeSlot {
    private List<DayOfWeek> days;
    private List<HoursTimeSlot> hoursTimeSlots;

    public DaysTimeSlot(List<DayOfWeek> days, List<HoursTimeSlot> hoursTimeSlots) {
        this.days = days;
        this.hoursTimeSlots = hoursTimeSlots;
    }

    public DaysTimeSlot() {
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(List<DayOfWeek> days) {
        this.days = days;
    }

    public List<HoursTimeSlot> getHoursTimeSlots() {
        return hoursTimeSlots;
    }

    public void setHoursTimeSlots(List<HoursTimeSlot> hoursTimeSlots) {
        this.hoursTimeSlots = hoursTimeSlots;
    }
}
