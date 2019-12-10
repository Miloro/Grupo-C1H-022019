package com.viandasya.model.menu;

import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.user.ServiceProfile;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Where(clause = "score is null or score >= 2")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private Double score;

    @ElementCollection
    private List<Category> categories = new ArrayList<>();

    private DateTimeSlot validity;

    @OneToOne(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private DeliveryInfo deliveryInfo;

    private PriceHandler priceHandler;

    private Integer maxAmountPerDay;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    private Integer cookingTime;

    @ManyToOne
    private ServiceProfile serviceProfile;

    public Menu(String name, String description, List<Category> categories, DateTimeSlot validity, PriceHandler priceHandler, Integer maxAmountPerDay, Integer cookingTime) {
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.validity = validity;
        this.priceHandler = priceHandler;
        this.maxAmountPerDay = maxAmountPerDay;
        this.cookingTime = cookingTime;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public DateTimeSlot getValidity() {
        return validity;
    }

    public void setValidity(DateTimeSlot validity) {
        this.validity = validity;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void addDeliveryInfo(DeliveryInfo deliveryInfo) {
        deliveryInfo.setMenu(this);
        this.deliveryInfo = deliveryInfo;
    }

    public Integer getMaxAmountPerDay() {
        return maxAmountPerDay;
    }

    public void setMaxAmountPerDay(Integer maxAmountPerDay) {
        this.maxAmountPerDay = maxAmountPerDay;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        order.setMenu(this);
        this.orders.add(order);
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public ServiceProfile getServiceProfile() {
        return serviceProfile;
    }

    public void setServiceProfile(ServiceProfile serviceProfile) {
        this.serviceProfile = serviceProfile;
    }

    public boolean isValid() {
        return this.validity.isValidDate(LocalDateTime.now());
    }

    public Offer getCurrentOffer() {
        return this.priceHandler.getCurrent();
    }

    private int getOrderCount() {
        return this.orders.stream().mapToInt(Order::getAmount).sum();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public PriceHandler getPriceHandler() {
        return priceHandler;
    }

    public void setPriceHandler(PriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public boolean updateScore() {
        int orderCount = 0;
        Double newScore = null;
        boolean isUpdated = false;
        for (Order order: this.orders)
            if (order.getState() == OrderState.DELIVERED && order.getScore() != null) {
                orderCount = orderCount + 1;
                if (newScore == null) newScore = order.getScore().doubleValue();
                else newScore += order.getScore().doubleValue();
            }
        if (orderCount >= 15) {
            isUpdated = this.score == null || this.score.compareTo(newScore) != 0;
            newScore = newScore / orderCount;
            this.score = newScore;
        }
        return isUpdated;
    }

    public boolean isDischarged() {
        return this.score == null || this.score.compareTo(2.0) >= 0;
    }
}
