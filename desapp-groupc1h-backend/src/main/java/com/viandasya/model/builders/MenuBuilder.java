package com.viandasya.model.builders;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.Discount;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.TimeSlot;

import java.util.List;

public class MenuBuilder {
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

    public MenuBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MenuBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public MenuBuilder setCategory(List<Category> category) {
        this.category = category;
        return this;
    }

    public MenuBuilder setDeliveryPrice(Integer deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
        return this;
    }

    public MenuBuilder setLifeTime(DateTimeSlot lifeTime) {
        this.lifeTime = lifeTime;
        return this;
    }

    public MenuBuilder setDeliveryDays(TimeSlot deliveryDays) {
        this.deliveryDays = deliveryDays;
        return this;
    }

    public MenuBuilder setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public MenuBuilder setAverageDeliveryTime(Integer averageDeliveryTime) {
        this.averageDeliveryTime = averageDeliveryTime;
        return this;
    }

    public MenuBuilder setDiscount1(Discount discount1) {
        this.discount1 = discount1;
        return this;
    }

    public MenuBuilder setDiscount2(Discount discount2) {
        this.discount2 = discount2;
        return this;
    }

    public MenuBuilder setMaxAmountPerDay(Integer maxAmountPerDay) {
        this.maxAmountPerDay = maxAmountPerDay;
        return this;
    }

    public Menu createMenu() {
        return new Menu(name, description, category, deliveryPrice, lifeTime, deliveryDays, price, averageDeliveryTime, discount1, discount2, maxAmountPerDay);
    }
}