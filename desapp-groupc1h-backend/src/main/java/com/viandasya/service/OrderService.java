package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.OrderRepository;
import com.viandasya.persistence.UserRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    private final MailSenderService mailSenderService;
    private Logger logger = LogManager.getLogger(OrderService.class);

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
        order.setOffer(menu.getCurrentOffer());
        BigDecimal price = order.getOffer().getPrice();
        clientProfile.getBalance().withdraw(price);
        ServiceProfile serviceProfile = menu.getServiceProfile();
        serviceProfile.getBalance().deposit(price);

        try {
            mailSenderService.sendEmail(serviceProfile.userEmail(),"El usuario compro el menu","Orden nueva" );
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return orderRepository.save(order);
    }

    @Transactional
    public Iterable<Order> getAllOrders(){
        return this.orderRepository.findAll();
    }

    @Transactional
    public void acceptOrders(){
        orderRepository.acceptOrders(OrderState.PENDING, OrderState.CONFIRMED);
    }

    @Transactional
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Transactional
    @Scheduled(cron = "0 0 1 * * ?")
    public void setAsDeliveredOrders() {
        this.orderRepository.setOrdersAsDelivered(LocalDateTime.now());
    }

    @Transactional
    public List<Order> findUnratedOrders(Long id) {
        return orderRepository.findUnratedOrdersByClientId(id);
    }

    @Transactional
    public void updateScoreByIdById(Integer score, Long id) {
        this.orderRepository.updateScoreById(score, id);
    }

    @Transactional
    public List<Order> findHistoricalOrders(Long idClient){
        return this.orderRepository.findOrderByClient_Id(idClient);
    }
}
