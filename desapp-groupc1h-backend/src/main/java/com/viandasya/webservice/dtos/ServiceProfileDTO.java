package com.viandasya.webservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.viandasya.model.timeslot.DayTimeSlot;
import com.viandasya.model.timeslot.TimeTable;
import com.viandasya.model.user.Location;
import com.viandasya.model.user.ServiceInfo;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.viandasya.model.builders.timeslot.TimeTableBuilder.anyTimeTable;


public class ServiceProfileDTO {
    private ServiceInfo serviceInfo;
    private List<DayTimeSlotDTO> timetable;
    private Location location;
    private double maxDistanceOfDeliveryInKms;
    @JsonIgnore
    private List<DayOfWeek> daysOfWeeks = Arrays.asList(DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

    public ServiceProfileDTO(ServiceInfo serviceInfo, List<DayTimeSlotDTO> timetable,
                             Location location, double maxDistanceOfDeliveryInKms) {
        this.serviceInfo = serviceInfo;
        this.timetable = timetable;
        this.location = location;
        this.maxDistanceOfDeliveryInKms = maxDistanceOfDeliveryInKms;
    }

    public ServiceProfileDTO() {
    }

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getMaxDistanceOfDeliveryInKms() {
        return maxDistanceOfDeliveryInKms;
    }

    public void setMaxDistanceOfDeliveryInKms(double maxDistanceOfDeliveryInKms) {
        this.maxDistanceOfDeliveryInKms = maxDistanceOfDeliveryInKms;
    }

    public List<DayTimeSlotDTO> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<DayTimeSlotDTO> timetable) {
        this.timetable = timetable;
    }

    public TimeTable convertTimeTable() {
        List<DayTimeSlot> dayTimeSlots = timetable.stream()
                .filter(DayTimeSlotDTO::isChecked)
                .map(DayTimeSlotDTO::convertDayTimeSlotDTO)
                .collect(Collectors.toList());
        return anyTimeTable().setDayTimeSlots(dayTimeSlots)
                .createTimeTable();
    }

    public void setTimeTable(TimeTable timeTable) {
        List<DayTimeSlotDTO> dayTimeSlotDTOs = new ArrayList<>();
        daysOfWeeks.forEach(day -> dayTimeSlotDTOs.add(this.convertDayTimeSlot(day, timeTable)));
        this.timetable = dayTimeSlotDTOs;
    }

    private DayTimeSlotDTO convertDayTimeSlot(DayOfWeek day, TimeTable timeTable) {
        return timeTable.getDayTimeSlots().stream()
                .filter(dayTimeSlot -> dayTimeSlot.getDay().equals(day))
                .map(dayTimeSlot -> {
                    DayTimeSlotDTO dayTimeSlotDTO = new DayTimeSlotDTO(day, true);
                    dayTimeSlotDTO.setHoursTimeSlot(dayTimeSlot.getHoursTimeSlots());
                    return dayTimeSlotDTO;
                })
                .findFirst()
                .orElseGet(() -> new DayTimeSlotDTO(day, false));
    }

}
