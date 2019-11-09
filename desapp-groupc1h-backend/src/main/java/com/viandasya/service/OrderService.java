package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.order.Order;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.persistence.ClientProfileRepository;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientProfileRepository clientProfileRepository;
    private final MenuRepository menuRepository;

    public OrderService(OrderRepository orderRepository, ClientProfileRepository clientProfileRepository, MenuRepository menuRepository) {
        this.orderRepository = orderRepository;
        this.clientProfileRepository = clientProfileRepository;
        this.menuRepository = menuRepository;
    }

    @Transactional
    public Order createOrder(Order order, long idMenu, long idClient){
        ClientProfile clientProfile = this.clientProfileRepository.findById(idClient).get();
        Menu menu = this.menuRepository.findById(idMenu).get();
        menu.addOrder(order);
        order.setClient(clientProfile);
        order.getOffers().add(menu.getCurrentOffer());
        BigDecimal price = order.getCurrentPrice();
        clientProfile.getBalance().withdraw(price);
        menu.getServiceProfile().getBalance().deposit(price);
        return orderRepository.save(order);
    }
}
