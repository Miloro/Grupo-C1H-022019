package com.viandasya.service;

import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.model.user.User;
import com.viandasya.persistence.ServiceProfileRepository;
import com.viandasya.persistence.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ServiceProfileService {
    private final UserRepository userRepository;
    private final ServiceProfileRepository serviceProfileRepository;

    public ServiceProfileService(UserRepository userRepository, ServiceProfileRepository serviceProfileRepository) {
        this.userRepository = userRepository;
        this.serviceProfileRepository = serviceProfileRepository;
    }

    @Transactional
    public long createServiceProfile(Long userId, ServiceProfile serviceProfile) {
        User user = userRepository.findById(userId).get();
        user.addServiceProfile(serviceProfile);
        return serviceProfileRepository.save(serviceProfile).getId();
    }

    @Transactional
    public Balance withdraw(long userId, Balance amount){
        User user = userRepository.findById(userId).get();
        user.getServiceProfile().getBalance().withdraw(amount.getAmount());
        userRepository.save(user);
        return user.getServiceProfile().getBalance();
    }

    public Balance deposit(Long userId, Balance amount) {
        User user = userRepository.findById(userId).get();
        user.getClientProfile().getBalance().deposit(amount.getAmount());
        userRepository.save(user);
        return user.getServiceProfile().getBalance();
    }
}
