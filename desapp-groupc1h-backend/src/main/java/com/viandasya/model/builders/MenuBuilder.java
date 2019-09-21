package com.viandasya.model.builders;

import com.viandasya.model.Category;
import com.viandasya.model.Menu;
import com.viandasya.model.timeslot.TimeSlot;

import java.time.LocalDate;
import java.util.List;

public class MenuBuilder {
    private String name;
    private String description;
    private List<Category> category;
    private Integer deliveryPrice;
    private LocalDate validSince;
    private LocalDate validFrom;
    private TimeSlot deliveryDays;
    private Integer price;
    private Integer averageDeliveryTime;
    private Integer minAmount;
    private Integer minAmount2;
    private Integer minAmountPrice;
    private Integer minAmountPrice2;
    private Integer maxAmountPerDay;

    public MenuBuilder(){}

    public MenuBuilder setName(String name){
        this.name = name;
        return this;
    }

    public MenuBuilder setDescription(String description){
        this.description = description;
        return this;
    }

    public MenuBuilder setCategory(List<Category> category){
        this.category = category;
        return this;
    }

    public MenuBuilder setDeliveryPrice(Integer deliveryPrice){
        this.deliveryPrice = deliveryPrice;
        return this;
    }

    public MenuBuilder setValidSince(LocalDate validSince){
        this.validSince = validSince;
        return this;
    }

    public MenuBuilder setValidFrom(LocalDate validFrom){
        this.validFrom = validFrom;
        return this;
    }

    public MenuBuilder setDeliveryDays(TimeSlot deliveryDays){
        this.deliveryDays = deliveryDays;
        return this;
    }

    public MenuBuilder setPrice(Integer price){
        this.price = price;
        return this;
    }

    public MenuBuilder setAverageDeliveryTime(Integer averageDeliveryTime){
        this.averageDeliveryTime = averageDeliveryTime;
        return this;
    }

    public MenuBuilder setMinAmount(Integer minAmount){
        this.minAmount = minAmount;
        return this;
    }

    public MenuBuilder setMinAmount2(Integer minAmount2){
        this.minAmount2 = minAmount2;
        return this;
    }

    public MenuBuilder setMinAmountPrice(Integer minAmountPrice){
        this.minAmountPrice = minAmountPrice;
        return this;
    }

    public MenuBuilder setMinAmountPrice2(Integer minAmountPrice2){
        return this;
    }

    public MenuBuilder setMaxAmountPerDay(Integer maxAmountPerDay){
        this.maxAmountPerDay = maxAmountPerDay;
        return this;
    }

    public Menu build(){
        return new Menu(name,description,category,deliveryPrice,validSince,validFrom,deliveryDays,price,averageDeliveryTime,minAmount,minAmount2,minAmountPrice,minAmountPrice2,maxAmountPerDay);
    }
}

