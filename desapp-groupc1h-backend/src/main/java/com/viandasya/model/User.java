package com.viandasya.model;

import java.util.List;

public class User {
    private String name;
    private String lastName;
    private String email;
    private Integer phoneNumber;
    private String city;
    private String adress;
    private Integer balance;
    private List<Menu> pendingMenusToScore;

    public User(String name, String lastName, String email, Integer phoneNumber, String city, String adress, Integer balance, List<Menu> pendingMenusToScore) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.adress = adress;
        this.balance = balance;
        this.pendingMenusToScore = pendingMenusToScore;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public List<Menu> getPendingMenusToScore() {
        return pendingMenusToScore;
    }

    public void setPendingMenusToScore(List<Menu> pendingMenusToScore) {
        this.pendingMenusToScore = pendingMenusToScore;
    }
}
