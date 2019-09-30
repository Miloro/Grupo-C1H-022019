package com.viandasya.model.menu;

import com.viandasya.model.timeslot.TimeSlot;

import java.math.BigDecimal;

public class DeliveryInfo {
    private TimeSlot timeslot;
    private BigDecimal price;
    private Integer averageTime;


    public DeliveryInfo(TimeSlot timeslot, BigDecimal price, Integer averageTime) {
        this.timeslot = timeslot;
        this.price = price;
        this.averageTime = averageTime;
    }

    public TimeSlot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeSlot timeslot) {
        this.timeslot = timeslot;
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
