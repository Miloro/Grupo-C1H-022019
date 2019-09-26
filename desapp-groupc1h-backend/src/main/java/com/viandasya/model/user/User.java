package com.viandasya.model.user;

class User {
    private Balance balance;
    private ClientProfile clientProfile;
    private ServiceProfile serviceProfile;

    public User(Balance balance, ClientProfile clientProfile, ServiceProfile serviceProfile) {
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

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

}
