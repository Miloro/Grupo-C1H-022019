package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.model.user.User;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.ServiceProfileRepository;
import com.viandasya.persistence.UserRepository;
import com.viandasya.webservice.dtos.ServiceProfileDTO;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ServiceProfileService {
    private final UserRepository userRepository;
    private final ServiceProfileRepository serviceProfileRepository;
    private final MailSenderService mailSenderService;
    private final MenuRepository menuRepository;

    public ServiceProfileService(UserRepository userRepository, ServiceProfileRepository serviceProfileRepository, MailSenderService mailSenderService, MenuRepository menuRepository) {
        this.userRepository = userRepository;
        this.serviceProfileRepository = serviceProfileRepository;
        this.mailSenderService = mailSenderService;
        this.menuRepository = menuRepository;
    }

    @Transactional
    public long create(String email, ServiceProfile serviceProfile) {
        return userRepository.findById(email).map(user -> {
            user.addServiceProfile(serviceProfile);
            return serviceProfileRepository.save(serviceProfile).getId();
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public Balance withdraw(String userId, Balance amount) {
        User user = userRepository.findById(userId).get();
        user.getServiceProfile().getBalance().withdraw(amount.getAmount());
        userRepository.save(user);
        return user.getServiceProfile().getBalance();
    }

    @Transactional
    @Scheduled(cron = "0 0 12 * * ?")
    public void updateScores() {
        this.menuRepository.findAllWithConfirmedOrders().forEach(menu -> {
            menu.updateScore();
            if (menu.getScore() != null && menu.getScore() < 2) {
               this.mailSenderService.sendMenuDischargedMessage(menu,
                       menu.getServiceProfile().getServiceInfo().geteMail());
            }
        });
        this.serviceProfileRepository.findAllWithFetchedMenus().forEach(serviceProfile -> {
            serviceProfile.updateScore();
            if (serviceProfile.getScore() != null && serviceProfile.getScore() < 2) {
                this.mailSenderService.sendServiceProfileDischargedMessage(serviceProfile.getServiceInfo());
            }
        });
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
