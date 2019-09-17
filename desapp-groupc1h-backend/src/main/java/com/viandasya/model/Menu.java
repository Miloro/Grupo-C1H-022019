package com.viandasya.model;

import java.time.LocalDate;
import java.util.List;

public class Menu {
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
    private  List<Score> scores;

    public Menu(String name, String description, List<Category> category, Integer deliveryPrice, LocalDate validSince, LocalDate validFrom, TimeSlot deliveryDays, Integer price, Integer averageDeliveryTime, Integer minAmount, Integer minAmount2, Integer minAmountPrice, Integer minAmountPrice2, Integer maxAmountPerDay, List<Score> scores) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.deliveryPrice = deliveryPrice;
        this.validSince = validSince;
        this.validFrom = validFrom;
        this.deliveryDays = deliveryDays;
        this.price = price;
        this.averageDeliveryTime = averageDeliveryTime;
        this.minAmount = minAmount;
        this.minAmount2 = minAmount2;
        this.minAmountPrice = minAmountPrice;
        this.minAmountPrice2 = minAmountPrice2;
        this.maxAmountPerDay = maxAmountPerDay;
        this.scores = scores;
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

    public Integer getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Integer deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public LocalDate getValidSince() {
        return validSince;
    }

    public void setValidSince(LocalDate validSince) {
        this.validSince = validSince;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
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

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getMinAmount2() {
        return minAmount2;
    }

    public void setMinAmount2(Integer minAmount2) {
        this.minAmount2 = minAmount2;
    }

    public Integer getMinAmountPrice() {
        return minAmountPrice;
    }

    public void setMinAmountPrice(Integer minAmountPrice) {
        this.minAmountPrice = minAmountPrice;
    }

    public Integer getMinAmountPrice2() {
        return minAmountPrice2;
    }

    public void setMinAmountPrice2(Integer minAmountPrice2) {
        this.minAmountPrice2 = minAmountPrice2;
    }

    public Integer getMaxAmountPerDay() {
        return maxAmountPerDay;
    }

    public void setMaxAmountPerDay(Integer maxAmountPerDay) {
        this.maxAmountPerDay = maxAmountPerDay;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

}
