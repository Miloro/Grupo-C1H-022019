package com.viandasya.model.timeslot;

import java.time.LocalTime;

public class HoursTimeSlot {
    private LocalTime since;
    private LocalTime  from;

    public HoursTimeSlot(LocalTime since, LocalTime from) {
        this.since = since;
        this.from = from;
    }

    public HoursTimeSlot() {
    }

    public LocalTime getSince() {
        return since;
    }

    public void setSince(LocalTime since) {
        this.since = since;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }
}
