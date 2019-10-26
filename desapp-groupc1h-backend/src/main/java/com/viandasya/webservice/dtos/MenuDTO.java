package com.viandasya.webservice.dtos;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.DeliveryInfo;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.order.Order;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.TimeTable;
import com.viandasya.model.user.ServiceProfile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MenuDTO {
    private String name;
    private String description;
    private List<Category> category;
    private DateTimeSlot validity;

    // deliveryInfo;
    private TimeTable deliveryInfoTimetable;
    private BigDecimal deliveryInfoPrice;
    private Integer deliveryInfoAverageTime;

    private List<Offer> offers;

    private Integer maxAmountPerDay;

    private Integer cookingTime;

    public MenuDTO(String name, String description, List<Category> category, DateTimeSlot validity, TimeTable deliveryInfoTimetable, BigDecimal deliveryInfoPrice, Integer deliveryInfoAverageTime, List<Offer> offers, Integer maxAmountPerDay, Integer cookingTime) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.validity = validity;
        this.deliveryInfoTimetable = deliveryInfoTimetable;
        this.deliveryInfoPrice = deliveryInfoPrice;
        this.deliveryInfoAverageTime = deliveryInfoAverageTime;
        this.offers = offers;
        this.maxAmountPerDay = maxAmountPerDay;
        this.cookingTime = cookingTime;
    }

    public MenuDTO() {
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

    public TimeTable getDeliveryInfoTimetable() {
        return deliveryInfoTimetable;
    }

    public void setDeliveryInfoTimetable(TimeTable deliveryInfoTimetable) {
        this.deliveryInfoTimetable = deliveryInfoTimetable;
    }

    public BigDecimal getDeliveryInfoPrice() {
        return deliveryInfoPrice;
    }

    public void setDeliveryInfoPrice(BigDecimal deliveryInfoPrice) {
        this.deliveryInfoPrice = deliveryInfoPrice;
    }

    public Integer getDeliveryInfoAverageTime() {
        return deliveryInfoAverageTime;
    }

    public void setDeliveryInfoAverageTime(Integer deliveryInfoAverageTime) {
        this.deliveryInfoAverageTime = deliveryInfoAverageTime;
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

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public DeliveryInfo getDeliveryInfoConverted() {
        return new DeliveryInfo(deliveryInfoTimetable,
                deliveryInfoPrice, deliveryInfoAverageTime);
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.setDeliveryInfoAverageTime(deliveryInfo.getAverageTime());
        this.setDeliveryInfoPrice(deliveryInfo.getPrice());
        this.setDeliveryInfoTimetable(deliveryInfo.getTimetable());
    }
}

