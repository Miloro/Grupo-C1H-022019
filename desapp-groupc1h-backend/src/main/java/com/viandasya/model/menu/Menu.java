package com.viandasya.model.menu;

import com.viandasya.model.order.Order;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.TimeSlot;

import java.time.LocalDateTime;
import java.util.List;

public class Menu {
    private String name;
    private String description;
    private List<Category> category;
    private DateTimeSlot validity;
    private TimeSlot deliveryDays;
    private Integer deliveryPrice;
    private Integer averageDeliveryTime;
    private PriceHandler priceHandler;
    private Integer maxAmountPerDay;
    private List<Order> orders;

    public Menu(String name, String description, List<Category> category, Integer deliveryPrice, DateTimeSlot validity, TimeSlot deliveryDays, Integer averageDeliveryTime, PriceHandler priceHandler, Integer maxAmountPerDay, List<Order> orders) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.deliveryPrice = deliveryPrice;
        this.validity = validity;
        this.deliveryDays = deliveryDays;
        this.averageDeliveryTime = averageDeliveryTime;
        this.priceHandler = priceHandler;
        this.maxAmountPerDay = maxAmountPerDay;
        this.orders = orders;
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

    public Integer getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Integer deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public DateTimeSlot getValidity() {
        return validity;
    }

    public void setValidity(DateTimeSlot validity) {
        this.validity = validity;
    }

    public TimeSlot getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(TimeSlot deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    public Integer getAverageDeliveryTime() {
        return averageDeliveryTime;
    }

    public void setAverageDeliveryTime(Integer averageDeliveryTime) {
        this.averageDeliveryTime = averageDeliveryTime;
    }

    public Integer getMaxAmountPerDay() {
        return maxAmountPerDay;
    }

    public void setMaxAmountPerDay(Integer maxAmountPerDay) {
        this.maxAmountPerDay = maxAmountPerDay;
    }

    public PriceHandler getPriceHandler() {
        return priceHandler;
    }

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public boolean isValid() {
        return this.validity.isValidDate(LocalDateTime.now());
    }

    public Integer getCurrentPrice() {
        return this.priceHandler.getCurrentPrice(this.getOrderCount());
    }

    private int getOrderCount() {
        return this.orders.stream().mapToInt(Order::getAmount).sum();
    }

}
