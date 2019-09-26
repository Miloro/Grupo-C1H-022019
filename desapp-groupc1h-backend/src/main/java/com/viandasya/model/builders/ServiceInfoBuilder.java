package com.viandasya.model.builders;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ServiceInfo;
import com.viandasya.model.timeslot.TimeSlot;

import java.util.Arrays;
import java.util.List;

import static com.viandasya.model.builders.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.MenuBuilder.anyMenu;

public class ServiceInfoBuilder {
    private String name = "El Rodeo";
    private String logo = ":)";
    private String adress= "San Martin 675";
    private String description = "Proveemos hamburguesas y papas fritas";
    private String website = "www.rodeoquilmes.com.ar";
    private String eMail = "rodeoquilmes01@gmail.com";
    private Integer phoneNumber = 42501324;

    public static ServiceInfoBuilder anyServiceInfo() {
        return new ServiceInfoBuilder();
    }

    public ServiceInfoBuilder setName(String name){
        this.name = name;
        return this;
    }

    public ServiceInfoBuilder setLogo(String logo){
        this.logo = logo;
        return this;
    }

    public ServiceInfoBuilder setAdress (String adress){
        this.adress = adress;
        return this;
    }

    public ServiceInfoBuilder setDescription(String description){
        this.description = description;
        return this;
    }

    public ServiceInfoBuilder setWebsite(String website){
        this.website = website;
        return this;
    }

    public ServiceInfoBuilder setEMail(String eMail){
        this.eMail = eMail;
        return this;
    }

    public ServiceInfoBuilder setPhoneNumber(Integer phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ServiceInfo createServiceInfo(){
        return new ServiceInfo(name,logo,adress,description,website,eMail,phoneNumber);
    }
}

