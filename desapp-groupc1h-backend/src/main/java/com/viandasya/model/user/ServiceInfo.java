package com.viandasya.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ServiceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private long id;

    private String name;
    private String logo;
    private String description;
    private String website;
    private String eMail;
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ServiceProfile serviceProfile;

    public ServiceInfo(String name, String logo, String description, String website, String eMail, String phoneNumber) {
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.website = website;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    public ServiceInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ServiceProfile getServiceProfile() {
        return serviceProfile;
    }

    public void setServiceProfile(ServiceProfile serviceProfile) {
        this.serviceProfile = serviceProfile;
    }

}
