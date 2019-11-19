package com.viandasya.webservice;

import com.viandasya.model.user.ClientProfile;
import com.viandasya.service.ClientProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientProfileController {
    private final  ClientProfileService clientProfileService;

    public ClientProfileController(ClientProfileService clientProfileService) {
        this.clientProfileService = clientProfileService;
    }

    @PostMapping("/client/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@PathVariable String id, @RequestBody ClientProfile clientProfile){
        clientProfileService.create(id, clientProfile);
    }

    @GetMapping("/clients")
    public Iterable<ClientProfile> findAll(){
        return clientProfileService.findAll();
    }

}
