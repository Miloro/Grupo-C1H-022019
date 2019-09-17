package com.viandasya.model;

import java.util.List;

public class TimeSlot {
    private List<DaysTimeSlot> daysTimeSlots;

    public TimeSlot(List<DaysTimeSlot> daysTimeSlots) {
        this.daysTimeSlots = daysTimeSlots;
    }

    public TimeSlot() {
    }

    public List<DaysTimeSlot> getDaysTimeSlots() {
        return daysTimeSlots;
    }

    public void setDaysTimeSlots(List<DaysTimeSlot> daysTimeSlots) {
        this.daysTimeSlots = daysTimeSlots;
    }

}
