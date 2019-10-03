package com.viandasya.model.builders.user;

import com.viandasya.model.timeslot.TimeTable;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ServiceInfo;
import com.viandasya.model.user.ServiceProfile;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

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
        ServiceProfile serviceProfile = anyServiceProfile().setTimeTable(timeTable).createServiceProfile();

        Assert.assertEquals(timeTable, serviceProfile.getTimetable());
    }

    @Test
    public void testSetBalanceSetedInBuilderEqualsToTheOneGettedInServiceProfile() {
        Balance balance = new Balance(new BigDecimal("100.50"));
        ServiceProfile serviceProfile = anyServiceProfile()
                .setBalance(balance)
                .createServiceProfile();

        Assert.assertEquals(balance, serviceProfile.getBalance());
    }
}
