package com.viandasya.model.user;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.timeslot.TimeTable;

import javax.persistence.*;
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
    private List<Menu> menus;

    private Balance balance;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public ServiceProfile(){}

    public ServiceProfile(ServiceInfo serviceInfo, TimeTable timetable, List<Menu> menus, Balance balance) {
        this.serviceInfo = serviceInfo;
        this.timetable = timetable;
        this.menus = menus;
        this.balance = balance;
    }

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(ServiceInfo serviceInfo) {
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

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Balance getBalance(){
        return this.balance;
    }

    public void setBalance(Balance balance){
        this.balance = balance;
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }

    public void removeMenu(Menu menu) {
        this.menus.remove(menu);
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
