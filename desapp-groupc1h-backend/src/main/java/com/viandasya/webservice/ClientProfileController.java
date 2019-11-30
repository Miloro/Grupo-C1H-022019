package com.viandasya.webservice;

import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.User;
import com.viandasya.service.ClientProfileService;
import com.viandasya.webservice.dtos.ClientProfileDTO;
import com.viandasya.webservice.dtos.UserDTO;
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

    @GetMapping("/user/email/{email}")
    public UserDTO getUser(@PathVariable String email){
        return clientProfileService.getUserbyEmail(email)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("user/{userId}/client")
    public Balance deposit(@PathVariable String userId, @RequestBody Balance amount){
        return clientProfileService.deposit(userId,amount);
    }


    @GetMapping("/clients")
    public Iterable<ClientProfile> findAll(){
        return clientProfileService.findAll();
    }

    private UserDTO convertToDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

}
