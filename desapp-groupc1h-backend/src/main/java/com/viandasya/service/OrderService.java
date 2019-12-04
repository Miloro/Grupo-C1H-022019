package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.OrderRepository;
import com.viandasya.persistence.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

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
        menu.addOrder(order);
        order.setClient(clientProfile);
        order.getOffers().add(menu.getCurrentOffer());
        BigDecimal price = order.getCurrentPrice();
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

    @Transactional
    public List<Order> getOrdersByState(OrderState state){
        return this.orderRepository.findAllByOrState(state);
    }

    @Transactional
    public void acceptOrders(){
        orderRepository.acceptOrders(OrderState.PENDING, OrderState.CONFIRMED);
    }
}
