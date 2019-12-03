package com.viandasya.webservice.dtos;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.DeliveryInfo;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.menu.PriceHandler;
import com.viandasya.model.timeslot.DateTimeSlot;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.viandasya.model.builders.menu.PriceHandlerBuilder.anyPriceHandler;
import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;

public class CreateMenuDTO {
    private String name;
    private String description;
    private List<Category> categories;
    private List<LocalDateTime> validity;
    private Integer cookingTime;
    private DeliveryInfoDTO deliveryInfoDTO;
    private BigDecimal price;
    private Integer maxAmountPerDay;
    private List<Offer> offers;

    public CreateMenuDTO() {
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public DateTimeSlot getValidity() {
        return anyDateTimeSlot().setFrom(validity.get(0)).setTo(validity.get(1))
                .createDateTimeSlot();
    }

    public void setValidity(List<LocalDateTime> validity) {
        this.validity = validity;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfoDTO.getDeliveryInfo();
    }

    public void setDeliveryInfoDTO(DeliveryInfoDTO deliveryInfoDTO) {
        this.deliveryInfoDTO = deliveryInfoDTO;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getMaxAmountPerDay() {
        return maxAmountPerDay;
    }

    public void setMaxAmountPerDay(Integer maxAmountPerDay) {
        this.maxAmountPerDay = maxAmountPerDay;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public PriceHandler getPriceHandler() {
        return anyPriceHandler().setCurrent(new Offer(0, price))
                .setOffers(offers).createPriceHandler();
    }

}
