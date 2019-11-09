package com.viandasya.service;

import com.viandasya.model.user.ClientProfile;
import com.viandasya.persistence.ClientProfileRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClientProfileService {
    private final ClientProfileRepository clientProfileRepository;

    public ClientProfileService(ClientProfileRepository clientProfileRepository) {
        this.clientProfileRepository = clientProfileRepository;
    }

    @Transactional
    public ClientProfile createClientProfile(ClientProfile clientProfile){
        return clientProfileRepository.save(clientProfile);

    }
}
