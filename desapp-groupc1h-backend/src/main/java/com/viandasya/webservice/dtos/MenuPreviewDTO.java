package com.viandasya.webservice.dtos;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.menu.PriceHandler;
import com.viandasya.model.user.Location;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MenuPreviewDTO {
    private long id;
    private String name;
    private String description;
    private Double score;
    private List<Category> categories;
    private BigDecimal price;
    private List<Offer> offers = new ArrayList<>();
    private String serviceLogo;
    private String serviceName;
    private Double serviceScore;
    private Location serviceLocation;

    public MenuPreviewDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Double getScore() {
        return score;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setServiceScore(Double serviceScore) {
        this.serviceScore = serviceScore;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getServiceScore() {
        return serviceScore;
    }

    public Location getServiceLocation() {
        return serviceLocation;
    }

    public void setServiceLocation(Location serviceLocation) {
        this.serviceLocation = serviceLocation;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getServiceLogo() {
        return serviceLogo;
    }

    public void setServiceLogo(String serviceLogo) {
        this.serviceLogo = serviceLogo;
    }

    public void setPriceHandler(PriceHandler priceHandler) {
        this.price = priceHandler.getCurrent().getPrice();
        this.offers.addAll(priceHandler.getOffers());
    }

}
