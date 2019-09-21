package com.viandasya.model.builders;

import com.viandasya.model.ClientProfile;

public class ClientProfileBuilder {
    private String name;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String city;
    private String adress;

    public ClientProfileBuilder(){}

    public ClientProfileBuilder setName(String name){
        this.name = name;
        return this;
    }

    public ClientProfileBuilder setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public ClientProfileBuilder setEmail(String email){
        this.email = email;
        return this;
    }

    public ClientProfileBuilder setPhoneNumber(Integer phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ClientProfileBuilder setCity(String city){
        this.city = city;
        return this;
    }

    public ClientProfileBuilder setAdress(String adress){
        this.adress = adress;
        return this;
    }

    public ClientProfile build(){
        return new ClientProfile(name, lastName, email, phoneNumber, city, adress);
    }
}