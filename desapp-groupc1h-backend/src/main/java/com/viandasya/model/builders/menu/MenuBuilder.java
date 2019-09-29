package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.order.Order;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.TimeSlot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.viandasya.model.builders.menu.OfferBuilder.anyOffer;
import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.timeslot.DayTimeSlotBuilder.anyDayTimeSlot;

public class MenuBuilder {
    private String name = "Combo Vegetariano";
    private String description = "Es una ensalada de lechuga, tomate y huevo";
    private List<Category> category = Collections.singletonList(Category.GREEN);
    private Integer deliveryPrice = 30;
    private DateTimeSlot validity = anyDateTimeSlot().createDateTimeSlot();
    private TimeSlot deliveryDays = anyDayTimeSlot().createDayTimeSlot();
    private Integer averageDeliveryTime = 48;
    private List<Offer> offers = Arrays.asList(anyOffer().setPrice(200).createOffer(), anyOffer().createOffer());
    private Integer maxAmountPerDay = 33;
    private List<Order> orders = new ArrayList<>();

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

    public MenuBuilder setAverageDeliveryTime(Integer averageDeliveryTime) {
        this.averageDeliveryTime = averageDeliveryTime;
        return this;
    }

    public MenuBuilder setOffers(List<Offer> offers) {
        this.offers = offers;
        return this;
    }


    public MenuBuilder setMaxAmountPerDay(Integer maxAmountPerDay) {
        this.maxAmountPerDay = maxAmountPerDay;
        return this;
    }

    public MenuBuilder setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    public Menu createMenu() {
        return new Menu(name, description, category, deliveryPrice, validity, deliveryDays, averageDeliveryTime, offers, maxAmountPerDay, orders);
    }
}