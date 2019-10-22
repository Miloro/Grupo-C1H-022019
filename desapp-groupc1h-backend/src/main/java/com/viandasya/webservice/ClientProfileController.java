package com.viandasya.webservice;

import com.viandasya.model.user.ClientProfile;
import com.viandasya.service.ClientProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ClientProfileController {
    @Autowired
    @Qualifier("clientProfileService")
    ClientProfileService clientProfileService;

    @PutMapping("/client")
    public boolean addUser(@RequestBody @Valid ClientProfile clientProfile){
        return clientProfileService.createClientProfile(clientProfile);
    }

}
