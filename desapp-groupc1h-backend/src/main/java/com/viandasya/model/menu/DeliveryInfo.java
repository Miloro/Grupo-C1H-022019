package com.viandasya.model.menu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viandasya.model.timeslot.TimeTable;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class DeliveryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @MapsId
    private TimeTable timetable;

    private BigDecimal price;
    private Integer averageTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Menu menu;


    public DeliveryInfo(TimeTable timetable, BigDecimal price, Integer averageTime) {
        this.timetable = timetable;
        this.price = price;
        this.averageTime = averageTime;
    }

    public DeliveryInfo() {
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
