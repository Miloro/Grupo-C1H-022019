package com.viandasya.model.timeslot;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class DayTimeSlot implements TimeSlot{
    private DayOfWeek day;
    private List<HoursTimeSlot> hoursTimeSlots;

    public DayTimeSlot(DayOfWeek day, List<HoursTimeSlot> hoursTimeSlots) {
        this.day = day;
        this.hoursTimeSlots = hoursTimeSlots;
    }

    public DayTimeSlot() {
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public List<HoursTimeSlot> getHoursTimeSlots() {
        return hoursTimeSlots;
    }

    public void setHoursTimeSlots(List<HoursTimeSlot> hoursTimeSlots) {
        this.hoursTimeSlots = hoursTimeSlots;
    }

    @Override
    public boolean isValidDate(LocalDateTime date) {
        return date.getDayOfWeek().equals(day) && this.isBetweenHours(date);
    }

    private boolean isBetweenHours(LocalDateTime date) {
        return this.hoursTimeSlots.stream().anyMatch(h -> h.isValidDate(date));
    }
}
