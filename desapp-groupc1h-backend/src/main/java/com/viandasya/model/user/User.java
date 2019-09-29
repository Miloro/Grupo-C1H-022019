package com.viandasya.model.user;

class User {
    private ClientProfile clientProfile;
    private ServiceProfile serviceProfile;

    public User(ClientProfile clientProfile, ServiceProfile serviceProfile) {
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

}
