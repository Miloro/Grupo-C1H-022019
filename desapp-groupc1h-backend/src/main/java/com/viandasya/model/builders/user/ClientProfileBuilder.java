package com.viandasya.model.builders.user;

import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.Location;

import java.math.BigDecimal;

public class ClientProfileBuilder {
    private String name = "name";
    private String lastName = "lastName";
    private String email = "emailfalso@gmail.com";
    private Integer phoneNumber = 12345;
    private Location location= new Location("Calle 842 2602", "San Francisco Solano",
            -34.7805449, -58.3151092);
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

    public ClientProfileBuilder setLocation(Location location){
        this.location = location;
        return this;
    }

    public ClientProfileBuilder setBalance(Balance balance){
        this.balance = balance;
        return this;
    }

    public ClientProfile createClientProfile(){
        return new ClientProfile(name, lastName, email, phoneNumber, location, balance);
    }
}
