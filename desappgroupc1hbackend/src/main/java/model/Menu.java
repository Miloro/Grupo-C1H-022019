package model;

import java.time.LocalDate;
import java.util.List;

public class Menu {
    String name;
    String description;
    List<CategoryEnum> category;
    Integer deliveryPrice;
    LocalDate validSince;
    LocalDate validFrom;
    List<LocalDate> deliveryTime;
    Integer price;
    Integer averageDeliveryTime;
    Integer minAmount;
    Integer minAmount2;
    Integer minAmountPrice;
    Integer minAmountPrice2;
    Integer maxAmountPerDay;
    List<Score> scores;
}
