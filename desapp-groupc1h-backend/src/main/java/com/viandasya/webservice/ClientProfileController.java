package com.viandasya.webservice;

import com.viandasya.model.order.Order;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.service.ClientProfileService;
import com.viandasya.service.OrderService;
import com.viandasya.webservice.dtos.UnratedOrderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class ClientProfileController {
    private final  ClientProfileService clientProfileService;
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public ClientProfileController(ClientProfileService clientProfileService, OrderService orderService, ModelMapper modelMapper) {
        this.clientProfileService = clientProfileService;
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("user/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@PathVariable String id, @Valid @RequestBody ClientProfile clientProfile){
        return this.clientProfileService.create(id,clientProfile);
    }

    @GetMapping("/client/{id}")
    public boolean existsById(@PathVariable String id){
        return clientProfileService.existsById(id);
    }

    @GetMapping("client/{id}/orders/unrated")
    public Stream<UnratedOrderDTO> findUnratedOrders(@PathVariable Long id) {
        List<Order> unratedOrders = orderService.findUnratedOrders(id);
        return unratedOrders.stream().map(order -> {
            UnratedOrderDTO unratedOrderDTO = modelMapper.map(order, UnratedOrderDTO.class);
            unratedOrderDTO.setTotalPrice(order.calculatePrice());
            return unratedOrderDTO;
        });
    }

    @PutMapping("user/{userId}/client")
    public Balance deposit(@PathVariable String userId, @RequestBody Balance amount){
        return clientProfileService.deposit(userId,amount);
    }

    @GetMapping("/clients")
    public Iterable<ClientProfile> findAll(){
        return clientProfileService.findAll();
    }

}
