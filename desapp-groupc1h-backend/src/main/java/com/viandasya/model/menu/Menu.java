package com.viandasya.model.menu;

import com.viandasya.model.order.Order;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.user.ServiceProfile;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;

    @ElementCollection
    private List<Category> category;

    private DateTimeSlot validity;

    @OneToOne(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private DeliveryInfo deliveryInfo;

    @ElementCollection
    @OrderBy(value = "price asc")
    private List<Offer> offers = new ArrayList<>();

    private Integer maxAmountPerDay;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    private Integer cookingTime;

    @ManyToOne
    private ServiceProfile serviceProfile;

    public Menu(String name, String description, List<Category> category, DateTimeSlot validity, List<Offer> offers, Integer maxAmountPerDay, Integer cookingTime) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.validity = validity;
        this.offers = offers;
        this.maxAmountPerDay = maxAmountPerDay;
        this.cookingTime = cookingTime;
    }

    public Menu() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public DateTimeSlot getValidity() {
        return validity;
    }

    public void setValidity(DateTimeSlot validity) {
        this.validity = validity;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void addDeliveryInfo(DeliveryInfo deliveryInfo) {
        deliveryInfo.setMenu(this);
        this.deliveryInfo = deliveryInfo;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Integer getMaxAmountPerDay() {
        return maxAmountPerDay;
    }

    public void setMaxAmountPerDay(Integer maxAmountPerDay) {
        this.maxAmountPerDay = maxAmountPerDay;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        order.setMenu(this);
        this.orders.add(order);
    }

    public Integer getCookingTime(){
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime){
        this.cookingTime = cookingTime;
    }

    public ServiceProfile getServiceProfile() {
        return serviceProfile;
    }

    public void setServiceProfile(ServiceProfile serviceProfile) {
        this.serviceProfile = serviceProfile;
    }

    public boolean isValid() {
        return this.validity.isValidDate(LocalDateTime.now());
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Offer getCurrentOffer() {
        int orderCount = this.getOrderCount();
        return this.offers.stream().filter(o -> orderCount >= o.getMinAmount()).findFirst().get();
    }

    private int getOrderCount() {
        return this.orders.stream().mapToInt(Order::getAmount).sum();
    }

}
