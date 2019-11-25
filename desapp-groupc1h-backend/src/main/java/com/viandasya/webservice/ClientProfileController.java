package com.viandasya.webservice;

import com.viandasya.model.user.ClientProfile;
import com.viandasya.service.ClientProfileService;
import com.viandasya.webservice.dtos.ClientProfileDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ClientProfileController {
    private final  ClientProfileService clientProfileService;
    private final ModelMapper modelMapper;

    public ClientProfileController(ClientProfileService clientProfileService, ModelMapper modelMapper) {
        this.clientProfileService = clientProfileService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/client/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@PathVariable String id, @RequestBody ClientProfile clientProfile){
        clientProfileService.create(id, clientProfile);
    }

    @GetMapping("/client/{id}")
    public boolean existsById(@PathVariable String id){
        return clientProfileService.existsById(id);
    }

    @GetMapping("/client/email/{email}")
    public ClientProfileDTO getUser(@PathVariable String email){
        return clientProfileService.getUserbyEmail(email)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/clients")
    public Iterable<ClientProfile> findAll(){
        return clientProfileService.findAll();
    }

    private ClientProfileDTO convertToDTO(ClientProfile serviceProfile) {
        ClientProfileDTO ClientProfileDTO = modelMapper.map(serviceProfile, ClientProfileDTO.class);
        return ClientProfileDTO;
    }

}
