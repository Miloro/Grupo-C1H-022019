package model;

import java.time.LocalDate;

public abstract class AbstractOrder {
    StateEnum state;
    LocalDate orderDate;
    Integer score;
    Menu menu;
    Integer price;
    Integer amount;

}
