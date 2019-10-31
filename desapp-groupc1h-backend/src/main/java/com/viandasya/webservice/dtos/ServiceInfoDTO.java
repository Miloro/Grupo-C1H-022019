package com.viandasya.webservice.dtos;

public class ServiceInfoDTO {
    private String name;
    private String description;
    private String website;
    private String eMail;
    private Integer phoneNumber;

    public ServiceInfoDTO(String name, String description, String website, String eMail, Integer phoneNumber) {
        this.name = name;
        this.description = description;
        this.website = website;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    public ServiceInfoDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
