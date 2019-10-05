package com.viandasya.model.user;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.timeslot.TimeTable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ServiceProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "serviceProfile", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ServiceInfo serviceInfo;

    @OneToOne
    @MapsId
    private TimeTable timetable;

    @OneToMany(mappedBy = "serviceProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menus = new ArrayList<>();

    private Balance balance;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public ServiceProfile(){}

    public ServiceProfile(TimeTable timetable, Balance balance) {
        this.timetable = timetable;
        this.balance = balance;
    }

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public void addServiceInfo(ServiceInfo serviceInfo) {
        serviceInfo.setServiceProfile(this);
        this.serviceInfo = serviceInfo;
    }

    public TimeTable getTimetable() {
        return timetable;
    }

    public void setServiceHours(TimeTable serviceHours) {
        this.timetable = serviceHours;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public Balance getBalance(){
        return this.balance;
    }

    public void setBalance(Balance balance){
        this.balance = balance;
    }

    public void addMenu(Menu menu) {
        menu.setServiceProfile(this);
        this.menus.add(menu);
    }

    public boolean has20ValidMenus() {
        return this.menus.stream().filter(Menu::isValid).count() == 20;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
