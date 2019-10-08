package com.viandasya.model.user;

import javax.persistence.*;

@Entity
public class ServiceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String logo;
    private String adress;
    private String description;
    private String website;
    private String eMail;
    private Integer phoneNumber;
    private String city;

    @OneToOne(fetch = FetchType.LAZY)
    private ServiceProfile serviceProfile;

    public ServiceInfo(String name, String logo, String adress, String description, String website, String eMail, Integer phoneNumber, String city) {
        this.name = name;
        this.logo = logo;
        this.adress = adress;
        this.description = description;
        this.website = website;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.city = city;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public ServiceProfile getServiceProfile() {
        return serviceProfile;
    }

    public void setServiceProfile(ServiceProfile serviceProfile) {
        this.serviceProfile = serviceProfile;
    }

}
