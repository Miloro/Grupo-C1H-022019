package com.viandasya.webservice.dtos;

import com.viandasya.model.menu.DeliveryInfo;
import com.viandasya.model.timeslot.DayTimeSlot;
import com.viandasya.model.timeslot.TimeTable;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.viandasya.model.builders.timeslot.TimeTableBuilder.anyTimeTable;

public class DeliveryInfoDTO {
    private BigDecimal price;
    private Integer averageTime;
    private List<DayTimeSlotDTO> timetable;

    public DeliveryInfoDTO() {
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

    public TimeTable getTimetable() {
        List<DayTimeSlot> dayTimeSlots = timetable.stream()
                .filter(DayTimeSlotDTO::isChecked)
                .map(DayTimeSlotDTO::convertDayTimeSlotDTO)
                .collect(Collectors.toList());
        return anyTimeTable().setDayTimeSlots(dayTimeSlots)
                .createTimeTable();
    }

    public void setTimetable(List<DayTimeSlotDTO> timetable) {
        this.timetable = timetable;
    }

    public DeliveryInfo getDeliveryInfo() {
        return new DeliveryInfo(this.getTimetable(), price, averageTime);
    }
}
