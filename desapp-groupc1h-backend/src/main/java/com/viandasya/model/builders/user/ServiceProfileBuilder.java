package com.viandasya.model.builders.user;

import com.viandasya.model.timeslot.TimeTable;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.Location;
import com.viandasya.model.user.ServiceInfo;
import com.viandasya.model.user.ServiceProfile;

import java.math.BigDecimal;

import static com.viandasya.model.builders.timeslot.TimeTableBuilder.anyTimeTable;
import static com.viandasya.model.builders.user.ServiceInfoBuilder.anyServiceInfo;

public class ServiceProfileBuilder {
    private ServiceInfo serviceInfo = anyServiceInfo().createServiceInfo();
    private TimeTable timetable = anyTimeTable().createTimeTable();;
    private String balance = "0";
    private Location location = new Location("Viamonte 266, Ciudad de Buenos Aires, Ciudad de Buenos Aires",
            -34.5996841, -58.3711918);
    private double maxDistanceOfDeliveryInKms = 3;

    public static ServiceProfileBuilder anyServiceProfile() {
        return new ServiceProfileBuilder();
    }

    public ServiceProfileBuilder setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
        return this;
    }

    public ServiceProfileBuilder setBalance(String balance) {
        this.balance = balance;
        return this;
    }

    public ServiceProfileBuilder setTimetable(TimeTable timetable) {
        this.timetable = timetable;
        return this;
    }

    public ServiceProfileBuilder setLocation(Location location) {
        this.location = location;
        return this;
    }

    public ServiceProfileBuilder setMaxDistanceOfDeliveryInKms(double maxDistanceOfDeliveryInKms) {
        this.maxDistanceOfDeliveryInKms = maxDistanceOfDeliveryInKms;
        return this;
    }

    public ServiceProfile createServiceProfile() {
        ServiceProfile serviceProfile = new ServiceProfile(serviceInfo, timetable,
                location, maxDistanceOfDeliveryInKms);
        serviceProfile.setBalance(new Balance(new BigDecimal(balance)));
        return serviceProfile;
    }
}