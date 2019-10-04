package com.viandasya.model.timeslot;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Embeddable
public class HoursTimeSlot implements TimeSlot {
    @Column(name = "since_hour")
    private LocalTime since;

    @Column(name = "until_hour")
    private LocalTime until;

    public HoursTimeSlot(LocalTime since, LocalTime until) {
        this.since = since;
        this.until = until;
    }

    public HoursTimeSlot() {
    }

    public LocalTime getSince() {
        return since;
    }

    public void setSince(LocalTime since) {
        this.since = since;
    }

    public LocalTime getUntil() {
        return until;
    }

    public void setUntil(LocalTime until) {
        this.until = until;
    }

    @Override
    public boolean isValidDate(LocalDateTime date) {
        return !date.toLocalTime().isBefore(since) && !date.toLocalTime().isAfter(until);
    }
}
