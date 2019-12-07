package com.viandasya.webservice;

import com.viandasya.model.order.Order;
import com.viandasya.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
    }

    @PostMapping("menu/{idMenu}/user/{idUser}/order")
    public long addMenu(@PathVariable("idMenu") long idMenu,@PathVariable("idUser") String idUser , Long id, @RequestBody Order order){
        return orderService.createOrder(order,idMenu,idUser).getId();
    }

    @GetMapping("orders/delivered")
    public void setAsDeliveredOrders() {
        this.orderService.setAsDeliveredOrders();
    }

}
