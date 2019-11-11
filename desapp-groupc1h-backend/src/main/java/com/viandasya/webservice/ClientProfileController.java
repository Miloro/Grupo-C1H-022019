package com.viandasya.webservice;

import com.viandasya.model.user.ClientProfile;
import com.viandasya.service.ClientProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientProfileController {
    private final  ClientProfileService clientProfileService;

    public ClientProfileController(ClientProfileService clientProfileService) {
        this.clientProfileService = clientProfileService;
    }

    @PostMapping("/client")
    public ClientProfile create(ClientProfile clientProfile){
        return clientProfileService.create(clientProfile);
    }

    @GetMapping("/clients")
    public Iterable<ClientProfile> findAll(){
        return clientProfileService.findAll();
    }

}
