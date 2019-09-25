package com.viandasya.model.builders;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.model.timeslot.TimeSlot;

import java.util.Arrays;
import java.util.List;

import static com.viandasya.model.builders.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.MenuBuilder.anyMenu;

public class ServiceProfileBuilder {
    private String name = "El Rodeo";
    private String logo = ":)";
    private String adress= "San Martin 675";
    private String description = "Proveemos hamburguesas y papas fritas";
    private String website = "www.rodeoquilmes.com.ar";
    private String eMail = "rodeoquilmes01@gmail.com";
    private Integer phoneNumber = 42501324;
    private TimeSlot serviceDays = anyDateTimeSlot().createDateTimeSlot();
    private List<Menu> menus = Arrays.asList(anyMenu().setName("Comida muy green").createMenu(),
            anyMenu().createMenu());
    private Balance balance = new Balance(0);

    private ServiceProfileBuilder(){}

    public static ServiceProfileBuilder anyServiceProfile() {
        return new ServiceProfileBuilder();
    }

    public ServiceProfileBuilder setName(String name){
        this.name = name;
        return this;
    }

    public ServiceProfileBuilder setLogo(String logo){
        this.logo = logo;
        return this;
    }

    public ServiceProfileBuilder setAdress (String adress){
        this.adress = adress;
        return this;
    }

    public ServiceProfileBuilder setDescription(String description){
        this.description = description;
        return this;
    }

    public ServiceProfileBuilder setWebsite(String website){
        this.website = website;
        return this;
    }

    public ServiceProfileBuilder setEMail(String eMail){
        this.eMail = eMail;
        return this;
    }

    public ServiceProfileBuilder setPhoneNumber(Integer phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ServiceProfileBuilder setServiceDays(TimeSlot serviceDays){
        this.serviceDays = serviceDays;
        return this;
    }

    public ServiceProfileBuilder setMenus(List<Menu> menus){
        this.menus = menus;
        return this;
    }

    public ServiceProfile createServiceProfile(){
        return new ServiceProfile(name,logo,adress,description,website,eMail,phoneNumber,serviceDays,menus,balance);
    }
}

