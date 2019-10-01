package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.DeliveryInfo;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.order.Order;
import com.viandasya.model.timeslot.DateTimeSlot;

import java.math.BigDecimal;
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
    private DateTimeSlot validity = anyDateTimeSlot().createDateTimeSlot();
    private DeliveryInfo deliveryInfo = new DeliveryInfo(anyDayTimeSlot().createDayTimeSlot(), new BigDecimal("20"), 60);
    private List<Offer> offers = Arrays.asList(anyOffer().setPrice(new BigDecimal("200")).createOffer(), anyOffer().createOffer());
    private Integer maxAmountPerDay = 33;
    private List<Order> orders = new ArrayList<>();
    private Integer cookingTime = 15;

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

    public MenuBuilder setValidity(DateTimeSlot validity) {
        this.validity = validity;
        return this;
    }

    public MenuBuilder setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
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

    public MenuBuilder setCookingTime(Integer cookingTime){
        this.cookingTime = cookingTime;
        return this;
    }

    public Menu createMenu() {
        return new Menu(name, description, category, validity, deliveryInfo, offers, maxAmountPerDay, orders, cookingTime);
    }
}