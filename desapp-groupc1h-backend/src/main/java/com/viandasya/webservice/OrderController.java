package com.viandasya.webservice;

import com.viandasya.model.order.Order;
import com.viandasya.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
    }

    @PostMapping("api/menu/{idMenu}/client/{idClient}/order")
    public long addMenu(@PathVariable("idMenu") long idMenu,@PathVariable("idClient") long idClient , Long id, @RequestBody Order order){
        return orderService.createOrder(order,idMenu,idClient).getId();
    }

}
