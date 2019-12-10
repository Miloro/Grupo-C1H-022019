package com.viandasya.webservice.dtos;


import com.viandasya.model.timeslot.DateTimeSlot;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class UnratedOrderDTO {
    private Long id;
    private Integer amount;
    private String menuName;
    private DateTimeSlot orderDate;
    private BigDecimal totalPrice;

    public UnratedOrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<LocalDateTime> getOrderDate() {
        return Arrays.asList(this.orderDate.getFrom(), this.orderDate.getTo());
    }

    public void setOrderDate(DateTimeSlot orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
