package com.viandasya.service;

import com.viandasya.model.user.User;
import com.viandasya.persistence.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(User user){
        userRepository.save(user);
        try{
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
