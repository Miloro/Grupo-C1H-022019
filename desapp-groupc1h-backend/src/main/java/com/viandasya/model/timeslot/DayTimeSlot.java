package com.viandasya.model.timeslot;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DayTimeSlot implements TimeSlot{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private DayOfWeek day;

    @ElementCollection
    private List<HoursTimeSlot> hoursTimeSlots = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private TimeTable timeTable;

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

    public TimeTable getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }
}
