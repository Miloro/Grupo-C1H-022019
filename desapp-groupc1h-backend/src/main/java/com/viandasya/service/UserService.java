package com.viandasya.service;

import com.viandasya.model.user.User;
import com.viandasya.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

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
