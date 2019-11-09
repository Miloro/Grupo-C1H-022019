package com.viandasya.model.builders.user;

import com.viandasya.model.timeslot.TimeTable;
import com.viandasya.model.user.Location;
import com.viandasya.model.user.ServiceInfo;
import com.viandasya.model.user.ServiceProfile;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static com.viandasya.model.builders.timeslot.TimeTableBuilder.anyTimeTable;
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
        TimeTable timeTable = anyTimeTable().createTimeTable();
        ServiceProfile serviceProfile = anyServiceProfile().setTimetable(timeTable).createServiceProfile();

        Assert.assertEquals(timeTable, serviceProfile.getTimetable());
    }

    @Test
    public void testSetBalanceSetedInBuilderEqualsToTheOneGettedInServiceProfile() {
        String balance = "100.50";
        ServiceProfile serviceProfile = anyServiceProfile()
                .setBalance(balance)
                .createServiceProfile();

        Assert.assertEquals(balance, serviceProfile.getBalance().getAmount().toString());
    }

    @Test
    public void testSetLocationSetedInBuilderEqualsToTheOneGettedInServiceProfile() {
        Location location = Mockito.mock(Location.class);
        ServiceProfile serviceProfile = anyServiceProfile()
                .setLocation(location)
                .createServiceProfile();

        Assert.assertEquals(location, serviceProfile.getLocation());
    }

    @Test
    public void testSetMaxDistanceOfDeliveryInKmsSetedInBuilderEqualsToTheOneGettedInServiceProfile() {
        double maxDistanceOfDeliveryInKms = 3.23;
        ServiceProfile serviceProfile = anyServiceProfile()
                .setMaxDistanceOfDeliveryInKms(maxDistanceOfDeliveryInKms)
                .createServiceProfile();

        Assert.assertEquals(0, Double.compare(maxDistanceOfDeliveryInKms, serviceProfile.getMaxDistanceOfDeliveryInKms()));
    }
}
