package com.viandasya.webservice;

import com.viandasya.model.user.ServiceProfile;
import com.viandasya.service.ServiceProfileService;
import com.viandasya.webservice.dtos.ServiceProfileDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ServiceProfileController {
    private final ServiceProfileService serviceProfileService;
    private final ModelMapper modelMapper;

    public ServiceProfileController(ServiceProfileService serviceProfileService, ModelMapper modelMapper) {
        this.serviceProfileService = serviceProfileService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("user/{email}/service")
    @ResponseStatus(HttpStatus.CREATED)
    public long create(@PathVariable String email, @RequestBody ServiceProfileDTO serviceProfileDTO) {
        ServiceProfile serviceProfile = convertToEntity(serviceProfileDTO);
        return serviceProfileService.create(email, serviceProfile);
    }

    @GetMapping("services")
    public List<ServiceProfileDTO> findAll() {
        Iterable<ServiceProfile> serviceProfiles = serviceProfileService.findAll();
        List<ServiceProfileDTO> serviceProfileDTOS = new ArrayList<>();
        serviceProfiles.forEach(serviceProfile -> serviceProfileDTOS.add(convertToDTO(serviceProfile)));
        return serviceProfileDTOS;
    }

    @GetMapping("service/{id}")
    public ServiceProfileDTO findById(@PathVariable Long id) {
        return serviceProfileService.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("service/{id}")
    public void update(@PathVariable Long id, @RequestBody ServiceProfileDTO serviceProfileDTO) {
        Optional<ServiceProfile> serviceProfileToUpdate = serviceProfileService.findById(id);
        if (serviceProfileToUpdate.isPresent()) {
            serviceProfileService.update(serviceProfileToUpdate.get(), serviceProfileDTO);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    private ServiceProfileDTO convertToDTO(ServiceProfile serviceProfile) {
        ServiceProfileDTO serviceProfileDTO = modelMapper.map(serviceProfile, ServiceProfileDTO.class);
        serviceProfileDTO.setTimeTable(serviceProfile.getTimetable());
        return serviceProfileDTO;
    }

    private ServiceProfile convertToEntity(@RequestBody ServiceProfileDTO serviceProfileDTO) {
        ServiceProfile serviceProfile = modelMapper.map(serviceProfileDTO, ServiceProfile.class);
        serviceProfile.setTimetable(serviceProfileDTO.convertTimeTable());
        return serviceProfile;
    }

}
