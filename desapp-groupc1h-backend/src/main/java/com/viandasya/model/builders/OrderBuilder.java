package com.viandasya.model.builders;

import com.viandasya.model.menu.Offer;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;


import static com.viandasya.model.builders.menu.OfferBuilder.anyOffer;
import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.user.ClientProfileBuilder.anyClientProfile;
import static com.viandasya.model.builders.menu.MenuBuilder.anyMenu;

public class OrderBuilder {
    private Integer amount = 12;
    private Integer score = 2;
    private OrderState state = OrderState.CONFIRMED;
    private DateTimeSlot orderDate = anyDateTimeSlot().createDateTimeSlot();
    private Boolean isDelivery = false;
    private Menu menu = anyMenu().createMenu();
    private ClientProfile client = anyClientProfile().createClientProfile();
    private Offer offer = anyOffer().setPrice("210.32").setMinAmount(12).createOffer();

    public static OrderBuilder anyOrder(){
        return new OrderBuilder();
    }

    public OrderBuilder setAmount(Integer amount) {
        this.amount = amount;
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

    public OrderBuilder setOrderDate(DateTimeSlot orderDate) {
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

    public OrderBuilder setOffer(Offer offer) {
        this.offer = offer;
        return this;
    }

    public Order createOrder() {
        return new Order(amount, offer, score, state, orderDate, isDelivery, menu, client);
    }

}