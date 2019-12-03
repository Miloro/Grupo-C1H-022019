package com.viandasya.model.menu;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
    PIZZA("Pizza"),
    BEER("Beer"),
    HAMBURGER("Hamburger"),
    SUSHI("Sushi"),
    EMPANADAS("Empanadas"),
    GREEN("Green"),
    VEGAN("Vegan");

    @JsonValue
    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
