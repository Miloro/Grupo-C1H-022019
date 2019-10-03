package com.viandasya.model.timeslot;

import java.time.LocalDateTime;
import java.util.List;

public class TimeTable implements TimeSlot {
    private List<DayTimeSlot> dayTimeSlots;

    public TimeTable(List<DayTimeSlot> dayTimeSlots) {
        this.dayTimeSlots = dayTimeSlots;
    }

    public TimeTable() {
    }

    public List<DayTimeSlot> getDayTimeSlots() {
        return dayTimeSlots;
    }

    public void setDayTimeSlots(List<DayTimeSlot> dayTimeSlots) {
        this.dayTimeSlots = dayTimeSlots;
    }

    @Override
    public boolean isValidDate(LocalDateTime date) {
        return this.dayTimeSlots.stream().anyMatch(timeslot -> timeslot.isValidDate(date));
    }
}
