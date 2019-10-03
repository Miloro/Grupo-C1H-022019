package com.viandasya.model.builders.user;

import com.viandasya.model.builders.timeslot.TimeTableBuilder;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.timeslot.TimeTable;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.model.user.ServiceInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.timeslot.TimeTableBuilder.*;
import static com.viandasya.model.builders.user.ServiceInfoBuilder.anyServiceInfo;

public class ServiceProfileBuilder {
    private ServiceInfo serviceInfo = anyServiceInfo().createServiceInfo();
    private TimeTable timeTable = anyTimeTable().createTimeTable();
    private List<Menu> menus = new ArrayList<>();
    private Balance balance = new Balance(new BigDecimal("0"));

    public static ServiceProfileBuilder anyServiceProfile(){
        return new ServiceProfileBuilder();
    }

    public ServiceProfileBuilder setServiceInfo(ServiceInfo serviceInfo){
        this.serviceInfo = serviceInfo;
        return this;
    }

    public ServiceProfileBuilder setTimeTable(TimeTable timeTable){
        this.timeTable = timeTable;
        return this;
    }

    public ServiceProfileBuilder setMenus (List<Menu> menus ){
        this.menus = menus;
        return this;
    }

    public ServiceProfileBuilder setBalance(Balance balance){
        this.balance = balance;
        return this;
    }

    public ServiceProfile createServiceProfile(){
        return new ServiceProfile(serviceInfo, timeTable, menus, balance);
    }
}
