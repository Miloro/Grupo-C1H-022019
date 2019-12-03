package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.order.Order;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.OrderRepository;
import com.viandasya.persistence.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    private final MailSenderService mailSenderService;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, MenuRepository menuRepository, MailSenderService mailSenderService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
        this.mailSenderService = mailSenderService;
    }

    @Transactional
    public Order createOrder(Order order, long idMenu, String idUser){
        ClientProfile clientProfile = this.userRepository.findById(idUser).get().getClientProfile();
        Menu menu = this.menuRepository.findById(idMenu).get();
        System.out.println(order);
        System.out.println(menu);
        System.out.println(clientProfile);
        menu.addOrder(order);
        order.setClient(clientProfile);
        order.setOffer(menu.getCurrentOffer());
        BigDecimal price = order.getOffer().getPrice();
        clientProfile.getBalance().withdraw(price);
        ServiceProfile serviceProfile = menu.getServiceProfile();
        serviceProfile.getBalance().deposit(price);

        try {
            mailSenderService.sendEmail(serviceProfile.userEmail(),"El usuario compro el menu","Orden nueva" );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderRepository.save(order);
    }
}
