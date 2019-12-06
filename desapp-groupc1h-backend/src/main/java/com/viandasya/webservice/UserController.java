package com.viandasya.webservice;

import com.viandasya.service.UserService;
import com.viandasya.webservice.dtos.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/{id}")
    public UserDTO findById(@PathVariable String id) {
        return this.userService.findById(id);
    }

}
