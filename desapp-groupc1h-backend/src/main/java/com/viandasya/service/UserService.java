package com.viandasya.service;

import com.viandasya.persistence.UserRepository;
import com.viandasya.webservice.dtos.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO findById(String id) {
        return this.userRepository.findByEmail(id);
    }
}
