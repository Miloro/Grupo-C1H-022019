package com.viandasya.model.user;

import javax.persistence.*;

@Entity(name = "UserProfile")
public class User {

    @Id
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ClientProfile clientProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ServiceProfile serviceProfile;

    public User() {
    }

    public ClientProfile getClientProfile() {
        return clientProfile;
    }

    public void addClientProfile(ClientProfile clientProfile) {
        this.clientProfile = clientProfile;
        clientProfile.setUser(this);
    }

    public ServiceProfile getServiceProfile() {
        return serviceProfile;
    }

    public void addServiceProfile(ServiceProfile serviceProfile) {
        this.serviceProfile = serviceProfile;
        serviceProfile.setUser(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
