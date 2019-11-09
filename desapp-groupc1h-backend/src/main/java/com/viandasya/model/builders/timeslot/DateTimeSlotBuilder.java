package com.viandasya.model.builders.timeslot;

import com.viandasya.model.timeslot.DateTimeSlot;

import java.time.LocalDateTime;

public class DateTimeSlotBuilder {
    private LocalDateTime from = LocalDateTime.now().minusDays(12);
    private LocalDateTime to = LocalDateTime.now().minusDays(7);

    public static DateTimeSlotBuilder anyDateTimeSlot() {
        return new DateTimeSlotBuilder();
    }

    public DateTimeSlotBuilder setFrom(LocalDateTime from) {
        this.from = from;
        return this;
    }

    public DateTimeSlotBuilder setTo(LocalDateTime to) {
        this.to = to;
        return this;
    }

    public DateTimeSlot createDateTimeSlot() {
        return new DateTimeSlot(from, to);
    }
}