package com.viandasya.model.builders.user;

import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.Location;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static com.viandasya.model.builders.user.ClientProfileBuilder.anyClientProfile;

public class ClientProfileBuilderTest {
    @Test
    public void testIsValidWhenICanCreateAClientProfileWithServiceClientProfileBuilder() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setName("name")
                .createClientProfile();

        Assert.assertEquals(anyClientProfile.getName(), "name");
    }

    @Test
    public void testIsValidWhenICanCreateAClientProfileWithServiceClientProfileBuilder2() {
        ClientProfile anyClientProfile  =  anyClientProfile()
                .setLastName("lastName")
                .createClientProfile();

        Assert.assertEquals(anyClientProfile.getLastName(), "lastName");
    }

    @Test
    public void testIsValidWhenICanCreateAClientProfileWithServiceClientProfileBuilder3() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setEmail("email")
                .createClientProfile();

        Assert.assertEquals(anyClientProfile.getEmail(), "email");
    }

    @Test
    public void testIsValidWhenICanCreateAClientProfileWithServiceClientProfileBuilder4() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setPhoneNumber(12345)
                .createClientProfile();

        Assert.assertEquals(anyClientProfile.getPhoneNumber(), 12345,0);
    }

    @Test
    public void testSetLocationSetedInBuilderEqualsToTheOneGettedInClientProfile() {
        Location location = Mockito.mock(Location.class);
        ClientProfile clientProfile = anyClientProfile()
                .setLocation(location)
                .createClientProfile();

        Assert.assertEquals(location, clientProfile.getLocation());
    }

    @Test
    public void testSetBalanceSetedInBuilderEqualsToTheOneGettedInClientProfile() {
        Balance balance = new Balance(new BigDecimal("100.50"));
        ClientProfile clientProfile = anyClientProfile()
                .setBalance(balance)
                .createClientProfile();

        Assert.assertEquals(balance, clientProfile.getBalance());
    }
}
