package com.viandasya.model.user;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.timeslot.TimeSlot;

import java.util.List;

public class ServiceProfile {
    private String name;
    private String logo;
    private String adress;
    private String description;
    private String website;
    private String eMail;
    private Integer phoneNumber;
    private TimeSlot serviceDays;
    private List<Menu> menus;

    public ServiceProfile(String name, String logo, String adress, String description, String website, String eMail, Integer phoneNumber, TimeSlot serviceDays, List<Menu> menus) {
        this.name = name;
        this.logo = logo;
        this.adress = adress;
        this.description = description;
        this.website = website;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.serviceDays = serviceDays;
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
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