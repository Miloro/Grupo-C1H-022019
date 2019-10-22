package com.viandasya.service;

import com.viandasya.model.user.ClientProfile;
import com.viandasya.persistence.ClientProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("clientProfileService")
public class ClientProfileService {
    @Autowired
    @Qualifier("clientProfileRepository")
    private ClientProfileRepository clientProfileRepository;

    public boolean createClientProfile(ClientProfile clientProfile){
        clientProfileRepository.save(clientProfile);
        try{
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
