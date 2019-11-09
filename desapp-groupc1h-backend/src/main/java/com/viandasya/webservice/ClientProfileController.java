package com.viandasya.webservice;

import com.viandasya.model.user.ClientProfile;
import com.viandasya.persistence.ClientProfileRepository;
import com.viandasya.service.ClientProfileService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ClientProfileController {
    private final  ClientProfileService clientProfileService;
    private final ClientProfileRepository clientProfileRepository;

    public ClientProfileController(ClientProfileService clientProfileService, ClientProfileRepository clientProfileRepository) {
        this.clientProfileService = clientProfileService;
        this.clientProfileRepository = clientProfileRepository;
    }

    @PutMapping("/client")
    public ClientProfile addUser(@RequestBody @Valid ClientProfile clientProfile){
        return clientProfileService.createClientProfile(clientProfile);
    }

    @GetMapping("/clients")
    public Iterable<ClientProfile> findAll(){
        return clientProfileRepository.findAll();
    }

}
