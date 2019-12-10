package com.viandasya.webservice;

import com.viandasya.model.order.Order;
import com.viandasya.service.CronTasksService;
import com.viandasya.service.OrderService;
import com.viandasya.webservice.dtos.ScoreDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private final OrderService orderService;
    private final CronTasksService cronTasksService;

    public OrderController(OrderService orderService, CronTasksService cronTasksService) {
        this.orderService = orderService;
        this.cronTasksService = cronTasksService;
    }

    @PostMapping("menu/{idMenu}/user/{idUser}/order")
    public long addMenu(@PathVariable("idMenu") long idMenu,@PathVariable("idUser") String idUser , @RequestBody Order order){
        return orderService.createOrder(order,idMenu,idUser).getId();
    }

    @GetMapping("orders/set-delivered")
    public void setAsDeliveredOrders() {
        this.orderService.setAsDeliveredOrders();
    }

    @PutMapping("order/{id}/score")
    public void updateScore(@PathVariable Long id, @RequestBody ScoreDTO scoreDTO) {
        this.orderService.updateScoreByIdById(scoreDTO.getScore(), id);
    }

    @GetMapping("orders/set-confirmed")
    public void setAsConfirmedOrders() {
        this.cronTasksService.acceptOrders();
    }

}
