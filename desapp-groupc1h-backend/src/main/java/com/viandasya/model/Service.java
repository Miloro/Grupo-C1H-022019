package com.viandasya.model;

import java.util.List;

public class Service {
    private String name;
    private String logo;
    private String adress;
    private String description;
    private String website;
    private String eMail;
    private Integer phoneNumber;
    private TimeSlot serviceDays;
    private List<Menu> menus;

    public Service(String name, String logo, String adress, String description, String website, String eMail, Integer phoneNumber, TimeSlot serviceDays, List<Menu> menus) {
        this.name = name;
        this.logo = logo;
        this.adress = adress;
        this.description = description;
        this.website = website;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.serviceDays = serviceDays;
        this.menus = menus;
    }

    public static class Builder{
        private String name;
        private String logo;
        private String adress;
        private String description;
        private String website;
        private String eMail;
        private Integer phoneNumber;
        private TimeSlot serviceDays;
        private List<Menu> menus;

        public Builder(){}

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setLogo(String logo){
            this.logo = logo;
            return this;
        }

        public Builder SetAdress (String adress){
            this.adress = adress;
            return this;
        }

        public Builder SetDescription(String description){
            this.description = description;
            return this;
        }

        public Builder SetWebsite(String website){
            this.website = website;
            return this;
        }

        public Builder SetEMail(String eMail){
            this.eMail = eMail;
            return this;
        }

        public Builder SetPhoneNumber(Integer phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder SetServiceDays(TimeSlot serviceDays){
            this.serviceDays = serviceDays;
            return this;
        }

        public Builder SetMenus(List<Menu> menus){
            this.menus = menus;
            return this;
        }

        public Service build(){
            return new Service(name,logo,adress,description,website,eMail,phoneNumber,serviceDays,menus);
        }
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

    public TimeSlot getServiceHours() {
        return serviceDays;
    }

    public void setServiceHours(TimeSlot serviceHours) {
        this.serviceDays = serviceHours;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}