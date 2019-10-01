package com.viandasya.model.menu;

import com.viandasya.model.order.Order;
import com.viandasya.model.timeslot.DateTimeSlot;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Menu {
    private String name;
    private String description;
    private List<Category> category;
    private DateTimeSlot validity;
    private DeliveryInfo deliveryInfo;
    private List<Offer> offers; //order by price asc
    private Integer maxAmountPerDay;
    private List<Order> orders;
    private Integer cookingTime;

    public Menu(String name, String description, List<Category> category, DateTimeSlot validity, DeliveryInfo deliveryInfo, List<Offer> offers, Integer maxAmountPerDay, List<Order> orders, Integer cookingTime) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.validity = validity;
        this.deliveryInfo = deliveryInfo;
        this.offers = offers;
        this.maxAmountPerDay = maxAmountPerDay;
        this.orders = orders;
        this.cookingTime = cookingTime;
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

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
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

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getCookingTime(){
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime){
        this.cookingTime = cookingTime;
    }

    public boolean isValid() {
        return this.validity.isValidDate(LocalDateTime.now());
    }

    public BigDecimal getCurrentPrice() {
        int orderCount = this.getOrderCount();
        return this.offers.stream().filter(o -> orderCount >= o.getMinAmount()).findFirst().get().getPrice();
    }

    private int getOrderCount() {
        return this.orders.stream().mapToInt(Order::getAmount).sum();
    }

}
