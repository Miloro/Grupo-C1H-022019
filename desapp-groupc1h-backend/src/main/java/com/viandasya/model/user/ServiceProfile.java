package com.viandasya.model.user;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.timeslot.TimeTable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ServiceProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "serviceProfile", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private ServiceInfo serviceInfo;

    @OneToOne
    @MapsId
    private TimeTable timetable;

    @OneToMany(mappedBy = "serviceProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menus = new ArrayList<>();

    private Balance balance = new Balance(new BigDecimal("0"));

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    private Location location;

    private double maxDistanceOfDeliveryInKms;

    private Double score;

    public ServiceProfile(ServiceInfo serviceInfo, TimeTable timetable,
                          Location location, double maxDistanceOfDeliveryInKms) {
        this.setServiceInfo(serviceInfo);
        this.timetable = timetable;
        this.location = location;
        this.maxDistanceOfDeliveryInKms = maxDistanceOfDeliveryInKms;
    }

    public ServiceProfile(){}

    public long getId() {
        return id;
    }

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(ServiceInfo serviceInfo) {
        serviceInfo.setServiceProfile(this);
        this.serviceInfo = serviceInfo;
    }

    public TimeTable getTimetable() {
        return timetable;
    }

    public void setTimetable(TimeTable timetable) {
        this.timetable = timetable;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public Balance getBalance(){
        return this.balance;
    }

    public void setBalance(Balance balance){
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getMaxDistanceOfDeliveryInKms() {
        return maxDistanceOfDeliveryInKms;
    }

    public void setMaxDistanceOfDeliveryInKms(double maxDistanceOfDeliveryInKms) {
        this.maxDistanceOfDeliveryInKms = maxDistanceOfDeliveryInKms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String userEmail() {
        return user.getEmail();
    }

    public void addMenu(Menu menu) {
        menu.setServiceProfile(this);
        this.menus.add(menu);
    }

    public boolean has20ValidMenus() {
        return this.menus.stream().filter(Menu::isValid).count() == 20;
    }

    public List<Menu> updateScore() {
        List<Menu> updatedMenus = new ArrayList<>();
        int menuCount = 0;
        Double newScore = null;
        for (Menu menu: this.menus) {
            if (menu.updateScore()) updatedMenus.add(menu);
            if (menu.getScore() != null) {
                if (newScore == null) newScore = menu.getScore();
                else newScore += menu.getScore();
                menuCount = menuCount + 1;
            }
        }
        if (newScore != null) this.score = newScore / menuCount;
        return updatedMenus;
    }

    public boolean isDischarged() {
        return this.score != null && this.score.compareTo(2.0) >= 0;
    }
}
