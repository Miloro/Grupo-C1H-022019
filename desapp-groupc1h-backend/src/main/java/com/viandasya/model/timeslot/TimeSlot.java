package com.viandasya.model.timeslot;

import java.time.LocalDateTime;

public interface TimeSlot {
    boolean isValidDate(LocalDateTime date);
}
