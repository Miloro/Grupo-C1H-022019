package com.viandasya.model.builders.user;

import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.user.ServiceInfo;
import com.viandasya.model.user.ServiceProfile;
import org.junit.Assert;
import org.junit.Test;

import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.user.ServiceInfoBuilder.anyServiceInfo;
import static com.viandasya.model.builders.user.ServiceProfileBuilder.anyServiceProfile;


public class ServiceProfileBuilderTest {

    @Test
    public void testSetServiceInfoSetedInBuilderEqualsToTheOneGettedInServiceProfile() {
        ServiceInfo serviceInfo = anyServiceInfo().createServiceInfo();
        ServiceProfile serviceProfile = anyServiceProfile().setServiceInfo(serviceInfo).createServiceProfile();

        Assert.assertEquals(serviceInfo, serviceProfile.getServiceInfo());
    }

    @Test
    public void setServiceDaysSetedInBuilderEqualsToTheOneGettedInServiceProfile() {
        DateTimeSlot dateTimeSlot = anyDateTimeSlot().createDateTimeSlot();
        ServiceProfile serviceProfile = anyServiceProfile().setServiceDays(dateTimeSlot).createServiceProfile();

        Assert.assertEquals(dateTimeSlot, serviceProfile.getServiceDays());
    }
}