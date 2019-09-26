package com.viandasya.model.user;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.timeslot.TimeSlot;

import java.util.List;

public class Service {
    private ServiceProfile serviceProfile;
    private TimeSlot serviceDays;
    private List<Menu> menus;
    private Balance balance;



    public Service(){}

    public Service(ServiceProfile serviceProfile,TimeSlot serviceDays, List<Menu> menus, Balance balance) {
        this.serviceProfile = serviceProfile;
        this.serviceDays = serviceDays;
        this.menus = menus;
        this.balance = balance;
    }

    public ServiceProfile getServiceProfile() {
        return serviceProfile;
    }

    public void setServiceProfile(ServiceProfile serviceProfile) {
        this.serviceProfile = serviceProfile;
    }

    public TimeSlot getServiceHours() {
        return serviceDays;
    }

    public void setServiceHours(TimeSlot serviceHours) {
        this.serviceDays = serviceHours;
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

}
