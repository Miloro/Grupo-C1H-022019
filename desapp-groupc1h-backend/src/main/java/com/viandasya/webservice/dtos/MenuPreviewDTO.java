package com.viandasya.webservice.dtos;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.user.Location;

import java.math.BigDecimal;
import java.util.List;

public class MenuPreviewDTO {
    private long id;
    private String name;
    private String description;
    private double score;
    private List<Category> categories;
    private BigDecimal price;
    private List<Offer> offers;
    private String serviceName;
    private double serviceScore;
    private Location serviceLocation;

    public MenuPreviewDTO() {
    }
}
