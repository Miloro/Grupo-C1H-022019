package com.viandasya.service;

import com.viandasya.model.user.ServiceInfo;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.model.user.User;
import com.viandasya.persistence.ServiceProfileRepository;
import com.viandasya.persistence.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.viandasya.model.builders.user.ServiceProfileBuilder.anyServiceProfile;

@Service
public class ServiceProfileService {
    private final UserRepository userRepository;
    private final ServiceProfileRepository serviceProfileRepository;

    public ServiceProfileService(UserRepository userRepository, ServiceProfileRepository serviceProfileRepository) {
        this.userRepository = userRepository;
        this.serviceProfileRepository = serviceProfileRepository;
    }

    @Transactional
    public void createService(Long id, ServiceInfo serviceInfo) {
        User user = userRepository.findById(id).get();
        ServiceProfile serviceProfile = anyServiceProfile()
                .setServiceInfo(serviceInfo)
                .createServiceProfile();
        user.addServiceProfile(serviceProfile);
        serviceProfileRepository.save(serviceProfile);
    }

}
