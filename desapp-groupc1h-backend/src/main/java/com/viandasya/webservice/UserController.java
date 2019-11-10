package com.viandasya.webservice;

import com.viandasya.model.user.ServiceProfile;
import com.viandasya.service.ServiceProfileService;
import com.viandasya.webservice.dtos.ServiceProfileDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final ServiceProfileService serviceProfileService;
    private final ModelMapper modelMapper;

    public UserController(ServiceProfileService serviceProfileService, ModelMapper modelMapper) {
        this.serviceProfileService = serviceProfileService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/{userId}/service")
    @ResponseStatus(HttpStatus.CREATED)
    public long createService(@PathVariable Long userId, @RequestBody ServiceProfileDTO serviceProfileDTO) {
        ServiceProfile serviceProfile = convertToEntity(serviceProfileDTO);
        return serviceProfileService.createServiceProfile(userId, serviceProfile);
    }

    private ServiceProfile convertToEntity(@RequestBody ServiceProfileDTO serviceProfileDTO) {
        ServiceProfile serviceProfile = modelMapper.map(serviceProfileDTO, ServiceProfile.class);
        serviceProfile.setTimetable(serviceProfileDTO.getTimeTableConverted());
        return serviceProfile;
    }

}