package com.viandasya.service;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import com.viandasya.model.user.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CronTasksService {
    private final OrderService orderService;
    private final MenuService menuService;
    private final ClientProfileService clientProfileService;
    private final MailSenderService mailSenderService;

    @Autowired
    public CronTasksService(OrderService orderService, MenuService menuService, ClientProfileService clientProfileService, MailSenderService mailSenderService) {
        this.orderService = orderService;
        this.menuService = menuService;
        this.clientProfileService = clientProfileService;
        this.mailSenderService = mailSenderService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void acceptOrders() {
        List<Order> orderPending = this.orderService.getOrdersByState(OrderState.PENDING);
        for (Order order : orderPending) {
            String receiver = order.getClient().getEmail();
            String body     = "su orden con el menu: "+ order.getMenu().getName() +" y la cantidad: " + order.getAmount()+ "fue aceptada";
            String subject  = "orden aceptada";
            this.sendMailTo(receiver,body,subject);
        }

        orderService.acceptOrders();

        List<Menu> menus = this.menuService.getAllMenus();

        for (Menu menu:menus){
            if(this.currentPriceOfTheMenuMhange(menu)){
                this.updatePriceAndNotifyUsers(menu);
            }
        }
    }

    private void sendMailTo(String receiver, String body, String subject){
        try {
            mailSenderService.sendEmail(receiver ,body ,subject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean currentPriceOfTheMenuMhange(Menu menu){
        BigDecimal oldPrice = new BigDecimal(menu.getPrice());
        return menu.getCurrentOffer().getPrice().compareTo(oldPrice) != 0 ;
    }

    private void updatePriceAndNotifyUsers(Menu menu){
        Offer newOffer = menu.getCurrentOffer();
        menu.setPrice(newOffer.getPrice().intValueExact());
        for(Order order : menu.getOrders()){
            BigDecimal oldOffer = order.getCurrentPrice();
            Balance moneyToReturn = new Balance(oldOffer.subtract(newOffer.getPrice()));
            clientProfileService.deposit(order.getClient().getEmail(),moneyToReturn);
            order.getOffers().add(newOffer);
            this.sendMailTo(order.getClient().getEmail(),
                      "el precio de su menu bajo, haciendo que recupere la suma de " + oldOffer.subtract(newOffer.getPrice()).intValueExact(),
                     "Bajo el precio");
        }
    }

}
