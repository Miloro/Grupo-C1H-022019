package com.viandasya.webservice.dtos;

public interface UserDTO {
    ServiceId getServiceProfile();
    ClientId getClientProfile();

    interface ServiceId {
        long getId();
        Double getScore();
        default boolean getIsDischarged() {
            return getScore() == null || getScore() >= 2.0;
        }
    }

    interface ClientId {
        long getId();
    }

}