package com.viandasya.webservice;

import com.viandasya.model.user.ClientProfile;
import com.viandasya.service.ClientProfileService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientProfileController {
    private final  ClientProfileService clientProfileService;

    public ClientProfileController(ClientProfileService clientProfileService) {
        this.clientProfileService = clientProfileService;
    }

    @PostMapping("/client")
    public Long create(@RequestBody ClientProfile clientProfile){
        return clientProfileService.create(clientProfile);
    }

    @GetMapping("/clients")
    public Iterable<ClientProfile> findAll(){
        return clientProfileService.findAll();
    }

}
