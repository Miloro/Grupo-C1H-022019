package com.viandasya.model.menu;

import com.viandasya.model.timeslot.TimeSlot;

public class DeliveryInfo {
    private TimeSlot timeslot;
    private Integer price;
    private Integer averageTime;


    public DeliveryInfo(TimeSlot timeslot, Integer price, Integer averageTime) {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Integer averageTime) {
        this.averageTime = averageTime;
    }
}
