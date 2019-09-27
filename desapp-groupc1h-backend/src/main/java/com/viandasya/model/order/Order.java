package com.viandasya.model.order;

import com.viandasya.model.menu.Offer;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.menu.Menu;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class Order {
    private Integer amount;
    private List<Offer> offers;
    private Integer score;
    private OrderState state;
    private LocalDateTime orderDate;
    private Boolean isDelivery;
    private Menu menu;
    private ClientProfile client;

    public Order(Integer amount, List<Offer> offers, Integer score, OrderState state, LocalDateTime orderDate, Boolean isDelivery, Menu menu, ClientProfile client) {
        this.amount = amount;
        this.offers = offers;
        this.score = score;
        this.state = state;
        this.orderDate = orderDate;
        this.isDelivery = isDelivery;
        this.menu = menu;
        this.client = client;
    }

    public Order() {
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Boolean getDelivery() {
        return isDelivery;
    }

    public void setDelivery(Boolean delivery) {
        isDelivery = delivery;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ClientProfile getClient() {
        return client;
    }

    public void setClient(ClientProfile client) {
        this.client = client;
    }

    public Integer getCurrentPrice(){
        return this.offers.stream().min(Comparator.comparingInt(Offer::getPrice)).get().getPrice();
    }
}
