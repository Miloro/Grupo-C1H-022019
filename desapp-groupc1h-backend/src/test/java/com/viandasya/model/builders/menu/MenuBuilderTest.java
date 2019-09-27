package com.viandasya.model.builders.menu;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.menu.PriceHandler;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.DayTimeSlot;
import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;

import static com.viandasya.model.builders.menu.MenuBuilder.anyMenu;
import static com.viandasya.model.builders.menu.PriceHandlerBuilder.anyPriceHandler;
import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.timeslot.DayTimeSlotBuilder.anyDayTimeSlot;

public class MenuBuilderTest {

    @Test
    public void testSetDeliveryDaysSetedInBuilderEqualsToTheOneGettedInMenu() {
        DayTimeSlot dayTimeSlot = anyDayTimeSlot().setDay(DayOfWeek.FRIDAY).createDayTimeSlot();
        Menu menu = anyMenu().setDeliveryDays(dayTimeSlot).createMenu();

        Assert.assertEquals(dayTimeSlot, menu.getDeliveryDays());
    }

    @Test
    public void setValiditySetedInBuilderEqualsToTheOneGettedInMenu() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot().createDateTimeSlot();
        Menu menu = anyMenu().setValidity(dateTimeSlot).createMenu();

        Assert.assertEquals(dateTimeSlot, menu.getValidity());
    }

    @Test
    public void setPriceHandlerSetedInBuilderEqualsToTheOneGettedInMenu() {
        PriceHandler priceHandler = anyPriceHandler().createPriceHandler();
        Menu menu = anyMenu().setPriceHandler(priceHandler).createMenu();

        Assert.assertEquals(priceHandler, menu.getPriceHandler());
    }

}