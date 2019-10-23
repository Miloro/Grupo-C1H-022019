package com.viandasya.webservice;

import com.viandasya.model.user.ServiceInfo;
import com.viandasya.service.ServiceProfileService;
import com.viandasya.webservice.dtos.ServiceInfoDTO;
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

    @PostMapping("/{id}/service")
    @ResponseStatus(HttpStatus.CREATED)
    public void createService(@PathVariable Long id, @RequestBody ServiceInfoDTO serviceInfoDTO) {
        ServiceInfo serviceInfo = modelMapper.map(serviceInfoDTO, ServiceInfo.class);
        serviceProfileService.createService(id, serviceInfo);
    }

}
