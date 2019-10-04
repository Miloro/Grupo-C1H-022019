package com.viandasya.model.timeslot;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class DateTimeSlot implements TimeSlot {

    @Column(name = "since_date")
    private LocalDateTime since;

    @Column(name = "until_date")
    private LocalDateTime until;

    public DateTimeSlot(LocalDateTime since, LocalDateTime until) {
        this.since = since;
        this.until = until;
    }

    public DateTimeSlot() {
    }

    public LocalDateTime getSince() {
        return since;
    }

    public void setSince(LocalDateTime since) {
        this.since = since;
    }

    public LocalDateTime getUntil() {
        return until;
    }

    public void setUntil(LocalDateTime until) {
        this.until = until;
    }

    @Override
    public boolean isValidDate(LocalDateTime date) {
        return !date.isBefore(since) && !date.isAfter(until);
    }
}
