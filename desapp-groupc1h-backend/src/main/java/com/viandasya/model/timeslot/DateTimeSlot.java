package com.viandasya.model.timeslot;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class DateTimeSlot {

    @Column(name = "from_date")
    private LocalDateTime from;

    @Column(name = "to_date")
    private LocalDateTime to;

    public DateTimeSlot(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public DateTimeSlot() {
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public boolean isValidDate(LocalDateTime date) {
        return !date.isBefore(from) && !date.isAfter(to);
    }
}
