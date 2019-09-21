package com.viandasya.model.builders;

import com.viandasya.model.Menu;
import com.viandasya.model.ServiceProfile;
import com.viandasya.model.timeslot.TimeSlot;

import java.util.List;

public class ServiceProfileBuilder {
    private String name;
    private String logo;
    private String adress;
    private String description;
    private String website;
    private String eMail;
    private Integer phoneNumber;
    private TimeSlot serviceDays;
    private List<Menu> menus;

    public ServiceProfileBuilder(){}

    public ServiceProfileBuilder setName(String name){
        this.name = name;
        return this;
    }

    public ServiceProfileBuilder setLogo(String logo){
        this.logo = logo;
        return this;
    }

    public ServiceProfileBuilder SetAdress (String adress){
        this.adress = adress;
        return this;
    }

    public ServiceProfileBuilder SetDescription(String description){
        this.description = description;
        return this;
    }

    public ServiceProfileBuilder SetWebsite(String website){
        this.website = website;
        return this;
    }

    public ServiceProfileBuilder SetEMail(String eMail){
        this.eMail = eMail;
        return this;
    }

    public ServiceProfileBuilder SetPhoneNumber(Integer phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ServiceProfileBuilder SetServiceDays(TimeSlot serviceDays){
        this.serviceDays = serviceDays;
        return this;
    }

    public ServiceProfileBuilder SetMenus(List<Menu> menus){
        this.menus = menus;
        return this;
    }

    public ServiceProfile build(){
        return new ServiceProfile(name,logo,adress,description,website,eMail,phoneNumber,serviceDays,menus);
    }
}

