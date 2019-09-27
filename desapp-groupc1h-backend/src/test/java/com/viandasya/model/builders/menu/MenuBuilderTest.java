package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.order.Order;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.viandasya.model.builders.menu.MenuBuilder.anyMenu;
import static org.junit.Assert.assertEquals;

public class MenuBuilderTest {

    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder() {
        Menu anyMenu = anyMenu()
                .setName("aaaaa")
                .createMenu();

        assertEquals(anyMenu.getName(),"aaaaa");
    }

    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder2() {
        Menu anyMenu = anyMenu()
                .setDescription("aaaaaaaaaaaaaaaaaaaaaaa")
                .createMenu();

        assertEquals(anyMenu.getDescription(),"aaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder3() {
        Menu anyMenu = anyMenu()
                .setCategory(Collections.singletonList(Category.GREEN))
                .createMenu();

        assertEquals(anyMenu.getCategory().get(0),Category.GREEN);
    }

    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder4() {
        Menu anyMenu = anyMenu()
                .setDeliveryPrice(30)
                .createMenu();

        assertEquals(anyMenu.getDeliveryPrice(),30,0);
    }


    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder5() {
        Menu anyMenu = anyMenu()
                .setAverageDeliveryTime(48)
                .createMenu();

        assertEquals(anyMenu.getAverageDeliveryTime(),48,0);
    }

    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder8() {
        Menu anyMenu = anyMenu()
                .setMaxAmountPerDay(33)
                .createMenu();

        assertEquals(anyMenu.getMaxAmountPerDay(),33,0);
    }

    @Test
    public void testIsValid_WhenICanCreateAMenuWithMenuBuilder9() {
        List<Order> orders = new ArrayList<>();
        Menu anyMenu = anyMenu()
                .setOrders(orders)
                .createMenu();

        assertEquals(anyMenu.getOrders().size(),0);
    }

}
