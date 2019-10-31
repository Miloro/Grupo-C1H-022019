package com.viandasya.model.timeslot;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Embeddable
public class HoursTimeSlot {
    @Column(name = "from_hour")
    private LocalTime from;

    @Column(name = "to_hour")
    private LocalTime to;

    public HoursTimeSlot(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    public HoursTimeSlot() {
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }

    public boolean isValidDate(LocalDateTime date) {
        return !date.toLocalTime().isBefore(from) && !date.toLocalTime().isAfter(to);
    }
}
