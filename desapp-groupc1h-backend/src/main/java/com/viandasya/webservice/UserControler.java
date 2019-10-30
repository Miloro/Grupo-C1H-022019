package com.viandasya.webservice;

import com.viandasya.model.user.User;
import com.viandasya.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserControler {
    private final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/usuario")
    public boolean addUser(User user){
        return userService.createUser(user);
    }
}
