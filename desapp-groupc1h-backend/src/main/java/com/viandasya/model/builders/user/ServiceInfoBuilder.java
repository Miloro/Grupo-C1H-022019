package com.viandasya.model.builders.user;


import com.viandasya.model.user.ServiceInfo;

public class ServiceInfoBuilder {
    private String name = "El Rodeo";
    private String logo = "https://codeclerks.com/pics/677-1wfYPM1479834803.jpg";
    private String description = "Proveemos hamburguesas y papas fritas";
    private String website = "www.rodeoquilmes.com.ar";
    private String eMail = "miloromiguel@gmail.com";
    private String phoneNumber = "1142501324";

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

    public ServiceInfoBuilder setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ServiceInfo createServiceInfo(){
        return new ServiceInfo(name,logo,description,website,eMail,phoneNumber);
    }
}

