package com.viandasya.webservice.dtos;

public interface UserDTO {
    ServiceId getServiceProfile();
    ClientId getClientProfile();

    interface ServiceId {
        long getId();
    }

    interface ClientId {
        long getId();
    }

}