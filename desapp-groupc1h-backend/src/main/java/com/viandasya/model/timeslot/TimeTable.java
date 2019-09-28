package com.viandasya.model.timeslot;

import java.time.LocalDateTime;
import java.util.List;

public class TimeTable implements TimeSlot {
    private List<TimeSlot> timeSlots;

    public TimeTable(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public TimeTable() {
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    @Override
    public boolean isValidDate(LocalDateTime date) {
        return this.timeSlots.stream().anyMatch(timeslot -> timeslot.isValidDate(date));
    }
}
