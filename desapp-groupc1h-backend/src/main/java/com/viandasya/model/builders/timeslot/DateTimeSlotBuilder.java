package com.viandasya.model.builders.timeslot;

import com.viandasya.model.timeslot.DateTimeSlot;

import java.time.LocalDateTime;

public class DateTimeSlotBuilder {
    private LocalDateTime since = LocalDateTime.now().minusDays(12);
    private LocalDateTime until = LocalDateTime.now().minusDays(7);

    public static DateTimeSlotBuilder anyDateTimeSlot() {
        return new DateTimeSlotBuilder();
    }

    public DateTimeSlotBuilder setSince(LocalDateTime since) {
        this.since = since;
        return this;
    }

    public DateTimeSlotBuilder setUntil(LocalDateTime from) {
        this.until = from;
        return this;
    }

    public DateTimeSlot createDateTimeSlot() {
        return new DateTimeSlot(since, until);
    }
}