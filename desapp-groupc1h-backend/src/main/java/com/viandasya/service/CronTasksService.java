package com.viandasya.service;


import com.viandasya.model.menu.Offer;
import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;

import com.viandasya.model.user.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;


@Service
public class CronTasksService {
    private final OrderService orderService;
    private final MailSenderService mailSenderService;
    private final ClientProfileService clientProfileService;

    @Autowired
    public CronTasksService(OrderService orderService, MailSenderService mailSenderService, ClientProfileService clientProfileService) {
        this.orderService = orderService;
        this.mailSenderService = mailSenderService;
        this.clientProfileService = clientProfileService;
    }

    @Transactional
    @Scheduled(cron = "0 0 * * * *")
    public void acceptOrders() {
        Iterable<Order> orders = this.orderService.getAllOrders();
        for (Order order : orders){
            if(order.getState() == OrderState.PENDING){
                /*
                String receiver = order.getClient().getEmail();
                String body     = "Su orden con el menu: "+ order.getMenu().getName() +" y la cantidad: " + order.getAmount()+ "fue aceptada";
                String subject  = "orden aceptada";
                this.sendMailTo(receiver,body,subject);

                 */
            }
            if(order.getState() == OrderState.CONFIRMED){
                this.updatePrice(order);
            }
        }
        orderService.acceptOrders();
        System.out.println("cron corrio completo");
    }

    private void updatePrice(Order order) {
        Offer orderOffer =  order.getOffer();
        Offer menuCurrentOffer = order.getMenu().getPriceHandler().getCurrent();
        if(orderOffer.getPrice().compareTo(menuCurrentOffer.getPrice()) > 0){
           order.setOffer(menuCurrentOffer);
           Balance change = new Balance(orderOffer.getPrice().subtract(menuCurrentOffer.getPrice()).multiply(new BigDecimal(order.getAmount())));
           this.clientProfileService.deposit(order.getClient().getEmail(),change);
           /*
           sendMailTo(order.getClient().getEmail(),
                   "El Menu que compro, bajo de precio y se le retorno a su cuenta la suma de: $" + change.getAmount().intValueExact(),
                   "Bajo el precio");

            */
        }
    }

    private void sendMailTo(String receiver, String body, String subject){
        try {
            mailSenderService.sendEmail(receiver ,body ,subject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
