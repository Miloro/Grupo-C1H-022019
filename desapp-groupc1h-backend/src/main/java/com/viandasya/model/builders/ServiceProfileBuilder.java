package com.viandasya.model.builders;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.timeslot.TimeSlot;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.model.user.ServiceInfo;

import java.util.ArrayList;
import java.util.List;

import static com.viandasya.model.builders.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.ServiceInfoBuilder.anyServiceInfo;

public class ServiceProfileBuilder {
    private ServiceInfo serviceInfo = anyServiceInfo().createServiceInfo();
    private TimeSlot serviceDays = anyDateTimeSlot().createDateTimeSlot();
    private List<Menu> menus = new ArrayList<>();
    private Balance balance = new Balance(0);

    public static ServiceProfileBuilder anyServiceProfile(){
        return new ServiceProfileBuilder();
    }

    public ServiceProfileBuilder setServiceInfo(ServiceInfo serviceInfo){
        this.serviceInfo = serviceInfo;
        return this;
    }

    public ServiceProfileBuilder setServiceDays (TimeSlot serviceDays){
        this.serviceDays = serviceDays;
        return this;
    }

    public ServiceProfileBuilder setMenus (List<Menu> menus ){
        this.menus = menus;
        return this;
    }

    public ServiceProfileBuilder setBalance (Balance balance){
        this.balance = balance;
        return this;
    }

    public ServiceProfile createServiceProfile(){
        return new ServiceProfile(serviceInfo,serviceDays,menus,balance);
    }
}
