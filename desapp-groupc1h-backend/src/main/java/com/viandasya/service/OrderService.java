package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.order.Order;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.persistence.ClientProfileRepository;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.OrderRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
        order.setMenu(menu);
        order.setClient(clientProfile);
        return orderRepository.save(order);
    }
}
