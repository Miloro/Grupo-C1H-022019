package com.viandasya.model.menu;

import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.TimeSlot;
import java.util.List;

public class Menu {
    private String name;
    private String description;
    private List<Category> category;
    private Integer deliveryPrice;
    private DateTimeSlot lifeTime;
    private TimeSlot deliveryDays;
    private Integer price;
    private Integer averageDeliveryTime;
    private Discount discount1;
    private Discount discount2;
    private Integer maxAmountPerDay;

    public Menu(String name, String description, List<Category> category, Integer deliveryPrice, DateTimeSlot lifeTime, TimeSlot deliveryDays, Integer price, Integer averageDeliveryTime, Discount discount1, Discount discount2, Integer maxAmountPerDay) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.deliveryPrice = deliveryPrice;
        this.lifeTime = lifeTime;
        this.deliveryDays = deliveryDays;
        this.price = price;
        this.averageDeliveryTime = averageDeliveryTime;
        this.discount1 = discount1;
        this.discount2 = discount2;
        this.maxAmountPerDay = maxAmountPerDay;
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

    public DateTimeSlot getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(DateTimeSlot lifeTime) {
        this.lifeTime = lifeTime;
    }

    public TimeSlot getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(TimeSlot deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAverageDeliveryTime() {
        return averageDeliveryTime;
    }

    public void setAverageDeliveryTime(Integer averageDeliveryTime) {
        this.averageDeliveryTime = averageDeliveryTime;
    }

    public Discount getDiscount1() {
        return discount1;
    }

    public void setDiscount1(Discount discount1) {
        this.discount1 = discount1;
    }

    public Discount getDiscount2() {
        return discount2;
    }

    public void setDiscount2(Discount discount2) {
        this.discount2 = discount2;
    }

    public Integer getMaxAmountPerDay() {
        return maxAmountPerDay;
    }

    public void setMaxAmountPerDay(Integer maxAmountPerDay) {
        this.maxAmountPerDay = maxAmountPerDay;
    }

}
