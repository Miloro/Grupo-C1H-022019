package com.viandasya.webservice.dtos;

public class UserDTO {

    private String email;

    private String clientProfileName;

    private String serviceProfileEmail;

    public UserDTO() {
    }

    public UserDTO(String email, String clientProfileName, String serviceProfileEmail) {
        this.email = email;
        this.clientProfileName = clientProfileName;
        this.serviceProfileEmail = serviceProfileEmail;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClientProfileName() {
        return clientProfileName;
    }

    public void setClientProfileName(String clientProfileName) {
        this.clientProfileName = clientProfileName;
    }

    public String getServiceProfileEmail() {
        return serviceProfileEmail;
    }

    public void setServiceProfileEmail(String serviceProfileEmail) {
        this.serviceProfileEmail = serviceProfileEmail;
    }
}
