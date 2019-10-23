package com.viandasya.webservice;

import com.viandasya.model.user.User;
import com.viandasya.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserControler {
    private final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/usuario")
    public boolean addUser(@RequestBody @Valid User user){
        return userService.createUser(user);
    }
}
