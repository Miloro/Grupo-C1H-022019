package com.viandasya.model;

import java.time.LocalDate;

public abstract class AbstractOrder {
    private OrderState state;
    private LocalDate orderDate;
    private Integer score;
    private Menu menu;
    private Integer price;
    private Integer amount;

}
