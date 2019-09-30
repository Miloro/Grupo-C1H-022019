package com.viandasya.model.builders.user;

import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ClientProfile;

import java.math.BigDecimal;

public class ClientProfileBuilder {
    private String name = "name";
    private String lastName = "lastName";
    private String email = "email";
    private Integer phoneNumber = 12345;
    private String city = "city";
    private String adress = "adress";
    private Balance balance = new Balance(new BigDecimal("0"));

    public static ClientProfileBuilder anyClientProfile(){
        return new ClientProfileBuilder();
    }

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

    public ClientProfileBuilder setBalance(Balance balance){
        this.balance = balance;
        return this;
    }

    public ClientProfile createClientProfile(){
        return new ClientProfile(name, lastName, email, phoneNumber, city, adress, balance);
    }
}