package com.viandasya.service;

import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.User;
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
    public Long create(ClientProfile clientProfile){
        User user = new User();
        user.addClientProfile(clientProfile);
        return clientProfileRepository.save(clientProfile).getId();
    }

    @Transactional
    public Iterable<ClientProfile> findAll() {
        return clientProfileRepository.findAll();
    }

}
