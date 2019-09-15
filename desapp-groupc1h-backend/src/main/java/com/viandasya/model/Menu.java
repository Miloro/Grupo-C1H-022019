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
    private List<LocalDate> deliveryTime;
    private Integer price;
    private Integer averageDeliveryTime;
    private Integer minAmount;
    private Integer minAmount2;
    private Integer minAmountPrice;
    private Integer minAmountPrice2;
    private Integer maxAmountPerDay;
    private  List<Score> scores;
}
