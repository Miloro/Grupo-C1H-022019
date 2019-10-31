package com.viandasya.model.order;

import com.viandasya.model.menu.Offer;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.menu.Menu;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Entity(name = "order_info")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Integer amount;

    @ElementCollection
    private List<Offer> offers = new ArrayList<>();
    private Integer score;

    @Enumerated(value = EnumType.STRING)
    private OrderState state;

    private DateTimeSlot orderDate;
    private Boolean isDelivery;

    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientProfile client;

    public Order(Integer amount, List<Offer> offers, Integer score, OrderState state, DateTimeSlot orderDate, Boolean isDelivery, Menu menu, ClientProfile client) {
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

    public DateTimeSlot getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(DateTimeSlot orderDate) {
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

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public BigDecimal getCurrentPrice(){
        return this.offers.stream().min(Comparator.comparing(Offer::getPrice)).get().getPrice();
    }

    public LocalDateTime averageTime(){
        if(isDelivery){
            return this.orderDate.getFrom().plusMinutes(this.menu.getCookingTime() + 15 ); //cambiar 15 por cuanto tarda en llegar en moto desde la api
        }
        else{
            return this.orderDate.getFrom().plusSeconds(this.menu.getCookingTime());
        }
    }
}