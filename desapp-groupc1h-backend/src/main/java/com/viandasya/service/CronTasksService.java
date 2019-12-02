package com.viandasya.service;

import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CronTasksService {
    private final OrderService orderService;
    private final MailSenderService mailSenderService;

    @Autowired
    public CronTasksService(OrderService orderService, MailSenderService mailSenderService) {
        this.orderService = orderService;
        this.mailSenderService = mailSenderService;
    }

    @Scheduled(cron = "1 * * * * *")
    public void acceptOrders() {
        List<Order> orderPending = this.orderService.getOrdersPending(OrderState.PENDING);

        for (Order order : orderPending) {
            String receiver = order.getClient().getEmail();
            String body     = "su orden con el menu: "+ order.getMenu().getName() +" y la cantidad: " + order.getAmount()+ "fue aceptada";
            String subject  = "orden aceptada";
            this.sendMailTo(receiver,body,subject);
        }

        //this.orderService.acceptOrders();
        System.out.println("Tarea usando expresiones cron");
    }

    private void sendMailTo(String receiver, String body, String subject){
        try {
            mailSenderService.sendEmail(receiver ,body ,subject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
