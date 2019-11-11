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
    public ClientProfile create(ClientProfile clientProfile){
        return clientProfileRepository.save(clientProfile);

    }

    @Transactional
    public Iterable<ClientProfile> findAll() {
        return clientProfileRepository.findAll();
    }

}
