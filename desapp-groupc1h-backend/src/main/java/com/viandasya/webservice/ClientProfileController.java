package com.viandasya.webservice;

import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.service.ClientProfileService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientProfileController {
    private final  ClientProfileService clientProfileService;
    private final ModelMapper modelMapper;

    public ClientProfileController(ClientProfileService clientProfileService, ModelMapper modelMapper) {
        this.clientProfileService = clientProfileService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("user/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@PathVariable String id, @RequestBody ClientProfile clientProfile){
        return this.clientProfileService.create(id,clientProfile);
    }

    @GetMapping("/client/{id}")
    public boolean existsById(@PathVariable String id){
        return clientProfileService.existsById(id);
    }

    @PutMapping("user/{userId}/client")
    public Balance deposit(@PathVariable String userId, @RequestBody Balance amount){
        return clientProfileService.deposit(userId,amount);
    }

    @GetMapping("/clients")
    public Iterable<ClientProfile> findAll(){
        return clientProfileService.findAll();
    }

}
