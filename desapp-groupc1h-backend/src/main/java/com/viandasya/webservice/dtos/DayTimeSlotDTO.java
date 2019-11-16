package com.viandasya.webservice.dtos;

import com.viandasya.model.timeslot.DayTimeSlot;
import com.viandasya.model.timeslot.HoursTimeSlot;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DayTimeSlotDTO {
    private DayOfWeek day;
    private boolean checked;
    private LocalTime from;
    private LocalTime to;

    public DayTimeSlotDTO(DayOfWeek day, boolean checked) {
        this.day = day;
        this.checked = checked;
    }

    public DayTimeSlotDTO() {
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public DayTimeSlot convertDayTimeSlotDTO() {
        List<HoursTimeSlot> hoursTimeSlots = new ArrayList<>();
        hoursTimeSlots.add(new HoursTimeSlot(this.from, this.to));
        return new DayTimeSlot(this.day, hoursTimeSlots);
    }

    public void setHoursTimeSlot(List<HoursTimeSlot> hoursTimeSlots) {
        HoursTimeSlot hoursTimeSlot = hoursTimeSlots.get(0);
        this.from = hoursTimeSlot.getFrom();
        this.to = hoursTimeSlot.getTo();
    }

}
