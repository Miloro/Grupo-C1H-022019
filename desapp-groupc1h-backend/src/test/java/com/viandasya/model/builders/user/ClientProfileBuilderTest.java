package com.viandasya.model.builders.user;

import com.viandasya.model.user.ClientProfile;
import org.junit.Assert;
import org.junit.Test;

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
    public void testIsValidWhenICanCreateAClientProfileWithServiceClientProfileBuilder5() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setCity("city")
                .createClientProfile();

        Assert.assertEquals(anyClientProfile.getCity(), "city");
    }

    @Test
    public void testIsValidWhenICanCreateAClientProfileWithServiceClientProfileBuilder6() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setAdress("adress")
                .createClientProfile();

        Assert.assertEquals(anyClientProfile.getAdress(), "adress");
    }
}
