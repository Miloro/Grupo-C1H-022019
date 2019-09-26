package com.viandasya.model.builders;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.sun.xml.internal.ws.api.addressing.OneWayFeature;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.viandasya.model.builders.ClientProfileBuilder.anyClientProfile;
import static com.viandasya.model.builders.MenuBuilder.anyMenu;

public class OrderBuilder {
    private Integer amount = 1234;
    private List<Offer> offers = Arrays.asList(new Offer(30,1));
    private Integer score = 2;
    private OrderState state = OrderState.CONFIRMED;
    private LocalDateTime orderDate = LocalDateTime.now();
    private Boolean isDelivery = false;
    private Menu menu = anyMenu().createMenu();
    private ClientProfile client = anyClientProfile().createClientProfile();

    public static OrderBuilder anyOrder(){
        return new OrderBuilder();
    }

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

    public Order createOrder() {
        return new Order(amount, offers, score, state, orderDate, isDelivery, menu, client);
    }
}