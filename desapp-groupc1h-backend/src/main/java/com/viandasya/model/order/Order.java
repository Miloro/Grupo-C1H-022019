package com.viandasya.model.order;

import com.viandasya.model.menu.Offer;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.menu.Menu;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "order_info")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Integer amount;

    private Offer offer;
    private Integer score;

    @Enumerated(value = EnumType.STRING)
    private OrderState state;

    private DateTimeSlot orderDate;
    private Boolean delivery;

    @ManyToOne(fetch = FetchType.EAGER)
    private Menu menu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private ClientProfile client;

    public Order(Integer amount, Offer offer, Integer score, OrderState state, DateTimeSlot orderDate, Boolean delivery, Menu menu, ClientProfile client) {
        this.amount = amount;
        this.offer = offer;
        this.score = score;
        this.state = state;
        this.orderDate = orderDate;
        this.delivery = delivery;
        this.menu = menu;
        this.client = client;
    }

    public Order() {
    }
    public long getId(){
        return id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public BigDecimal calculatePrice() {
        BigDecimal price = offer.getPrice().multiply(new BigDecimal(amount));
        if (delivery) return price.add(menu.getDeliveryInfo().getPrice());
        else return price;
    }

    public LocalDateTime averageTime(){
        if(delivery){
            return this.orderDate.getFrom().plusMinutes(this.menu.getCookingTime() + 15 ); //cambiar 15 por cuanto tarda en llegar en moto desde la api
        }
        else{
            return this.orderDate.getFrom().plusSeconds(this.menu.getCookingTime());
        }
    }

}
