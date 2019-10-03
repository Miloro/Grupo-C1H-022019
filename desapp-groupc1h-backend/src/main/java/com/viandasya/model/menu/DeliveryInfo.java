package com.viandasya.model.menu;

import com.viandasya.model.timeslot.TimeTable;

import java.math.BigDecimal;

public class DeliveryInfo {
    private TimeTable timetable;
    private BigDecimal price;
    private Integer averageTime;


    public DeliveryInfo(TimeTable timetable, BigDecimal price, Integer averageTime) {
        this.timetable = timetable;
        this.price = price;
        this.averageTime = averageTime;
    }

    public TimeTable getTimetable() {
        return timetable;
    }

    public void setTimetable(TimeTable timetable) {
        this.timetable = timetable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Integer averageTime) {
        this.averageTime = averageTime;
    }
}
