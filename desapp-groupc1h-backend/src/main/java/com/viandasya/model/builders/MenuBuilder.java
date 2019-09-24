package com.viandasya.model.builders;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.Discount;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.TimeSlot;

import java.util.Collections;
import java.util.List;

import static com.viandasya.model.builders.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.DayTimeSlotBuilder.anyDayTimeSlot;

public class MenuBuilder {
    private String name = "Combo Vegetariano";
    private String description = "Es una ensalada de lechuga, tomate y huevo";
    private List<Category> category = Collections.singletonList(Category.GREEN);
    private Integer deliveryPrice = 30;
    private DateTimeSlot validity = anyDateTimeSlot().createDateTimeSlot();
    private TimeSlot deliveryDays = anyDayTimeSlot().createDayTimeSlot();
    private Integer price = 300;
    private Integer averageDeliveryTime = 48;
    private Discount discount1 = new Discount(10, 250);
    private Discount discount2 = new Discount(20, 150);
    private Integer maxAmountPerDay = 33;

    public static MenuBuilder anyMenu() {
        return new MenuBuilder();
    }

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

    public MenuBuilder setValidity(DateTimeSlot validity) {
        this.validity = validity;
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
        return new Menu(name, description, category, deliveryPrice, validity, deliveryDays, price, averageDeliveryTime, discount1, discount2, maxAmountPerDay);
    }
}