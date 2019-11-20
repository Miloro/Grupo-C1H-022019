package com.viandasya.service;

import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.User;
import com.viandasya.persistence.ClientProfileRepository;
import com.viandasya.persistence.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClientProfileService {
    private final UserRepository userRepository;
    private final ClientProfileRepository clientProfileRepository;

    public ClientProfileService(UserRepository userRepository,
                                ClientProfileRepository clientProfileRepository) {
        this.userRepository = userRepository;
        this.clientProfileRepository = clientProfileRepository;
    }

    @Transactional
    public void create(String id, ClientProfile clientProfile){
        User user = new User();
        user.setEmail(id);
        user.addClientProfile(clientProfile);
        userRepository.save(user);
    }

    @Transactional
    public Iterable<ClientProfile> findAll() {
        return clientProfileRepository.findAll();
    }

    @Transactional
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }
}
