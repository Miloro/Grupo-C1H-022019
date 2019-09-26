package com.viandasya.model.builders;

import com.viandasya.model.menu.Offer;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;

import java.time.LocalDateTime;
import java.util.List;

public class OrderBuilder {
    private Integer amount;
    private List<Offer> offers;
    private Integer score;
    private OrderState state;
    private LocalDateTime orderDate;
    private Boolean isDelivery;
    private Menu menu;
    private ClientProfile client;

    public OrderBuilder setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public OrderBuilder setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }

    public OrderBuilder setScore(Integer score) {
        this.score = score;
        return this;
    }

    public OrderBuilder setState(OrderState state) {
        this.state = state;
        return this;
    }

    public OrderBuilder setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public OrderBuilder setIsDelivery(Boolean isDelivery) {
        this.isDelivery = isDelivery;
        return this;
    }

    public OrderBuilder setMenu(Menu menu) {
        this.menu = menu;
        return this;
    }

    public OrderBuilder setClient(ClientProfile client) {
        this.client = client;
        return this;
    }

    public Order build() {
        return new Order(amount, offers, score, state, orderDate, isDelivery, menu, client);
    }
}