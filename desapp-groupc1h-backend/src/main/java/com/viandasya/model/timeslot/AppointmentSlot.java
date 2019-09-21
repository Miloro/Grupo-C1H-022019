package com.viandasya.model.timeslot;

import java.time.LocalDateTime;

public class AppointmentSlot implements TimeSlot {
    private LocalDateTime since;
    private LocalDateTime from;

    public AppointmentSlot(LocalDateTime since, LocalDateTime from) {
        this.since = since;
        this.from = from;
    }

    public AppointmentSlot() {
    }

    public LocalDateTime getSince() {
        return since;
    }

    public void setSince(LocalDateTime since) {
        this.since = since;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    @Override
    public boolean isValidDate(LocalDateTime date) {
        return false;
    }
}
