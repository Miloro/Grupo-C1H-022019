package com.viandasya.service;

import com.viandasya.model.user.ServiceProfile;
import com.viandasya.model.user.User;
import com.viandasya.persistence.ServiceProfileRepository;
import com.viandasya.persistence.UserRepository;
import com.viandasya.webservice.dtos.ServiceProfileDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ServiceProfileService {
    private final UserRepository userRepository;
    private final ServiceProfileRepository serviceProfileRepository;

    public ServiceProfileService(UserRepository userRepository, ServiceProfileRepository serviceProfileRepository) {
        this.userRepository = userRepository;
        this.serviceProfileRepository = serviceProfileRepository;
    }

    @Transactional
    public long create(Long userId, ServiceProfile serviceProfile) {
        User user = userRepository.findById(userId).get();
        user.addServiceProfile(serviceProfile);
        return serviceProfileRepository.save(serviceProfile).getId();
    }

    @Transactional
    public Iterable<ServiceProfile> findAll() {
        return serviceProfileRepository.findAll();
    }

    @Transactional
    public Optional<ServiceProfile> findById(Long id) {
        return serviceProfileRepository.findById(id);
    }

    @Transactional
    public void update(ServiceProfile serviceProfile, ServiceProfileDTO serviceProfileDTO) {
        serviceProfile.setServiceInfo(serviceProfileDTO.getServiceInfo());
        serviceProfile.setTimetable(serviceProfileDTO.convertTimeTable());
        serviceProfile.setLocation(serviceProfileDTO.getLocation());
        serviceProfile.setMaxDistanceOfDeliveryInKms(serviceProfileDTO.getMaxDistanceOfDeliveryInKms());
    }

}
