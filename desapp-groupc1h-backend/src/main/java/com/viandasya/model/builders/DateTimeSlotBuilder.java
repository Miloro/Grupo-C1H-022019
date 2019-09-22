package com.viandasya.model.builders;

import com.viandasya.model.timeslot.DateTimeSlot;

import java.time.LocalDateTime;

public class DateTimeSlotBuilder {
    private LocalDateTime since = LocalDateTime.now().minusDays(12);
    private LocalDateTime from = LocalDateTime.now().minusDays(7);

    public static DateTimeSlotBuilder anyDateTimeSlot() {
        return new DateTimeSlotBuilder();
    }

    public DateTimeSlotBuilder setSince(LocalDateTime since) {
        this.since = since;
        return this;
    }

    public DateTimeSlotBuilder setFrom(LocalDateTime from) {
        this.from = from;
        return this;
    }

    public DateTimeSlot createDateTimeSlot() {
        return new DateTimeSlot(since, from);
    }
}