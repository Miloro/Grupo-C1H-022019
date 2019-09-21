package com.viandasya.model;

public class User {
    private Integer balance;
    private ClientProfile clientProfile;
    private ServiceProfile serviceProfile;

    public User(Integer balance, ClientProfile clientProfile, ServiceProfile serviceProfile) {
        this.balance = balance;
        this.clientProfile = clientProfile;
        this.serviceProfile = serviceProfile;
    }

    public User() {
    }

    public ClientProfile getClientProfile() {
        return clientProfile;
    }

    public void setClientProfile(ClientProfile clientProfile) {
        this.clientProfile = clientProfile;
    }

    public ServiceProfile getServiceProfile() {
        return serviceProfile;
    }

    public void setServiceProfile(ServiceProfile serviceProfile) {
        this.serviceProfile = serviceProfile;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

}
