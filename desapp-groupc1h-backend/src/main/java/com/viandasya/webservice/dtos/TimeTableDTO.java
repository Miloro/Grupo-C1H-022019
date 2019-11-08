package com.viandasya.webservice.dtos;

import java.time.LocalDateTime;

public class TimeTableDTO {

    public TimeTableDTO() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    private LocalDateTime date;

    public TimeTableDTO(LocalDateTime date) {
        this.date = date;
    }
}
