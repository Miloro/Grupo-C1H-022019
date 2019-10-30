package com.viandasya.model.timeslot;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "timeTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DayTimeSlot> dayTimeSlots = new ArrayList<>();

    public TimeTable() {
    }

    public List<DayTimeSlot> getDayTimeSlots() {
        return dayTimeSlots;
    }

    public void addDayTimeSlot(DayTimeSlot dayTimeSlot) {
        dayTimeSlot.setTimeTable(this);
        this.dayTimeSlots.add(dayTimeSlot);
    }

    public boolean isValidDate(LocalDateTime date) {
        return this.dayTimeSlots.stream().anyMatch(timeslot -> timeslot.isValidDate(date));
    }
}
