package com.viandasya.model.user;

import javax.persistence.*;

@Entity(name = "UserProfile")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ClientProfile clientProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
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

}
