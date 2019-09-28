package com.viandasya.model.builders.user;

import com.viandasya.model.user.ClientProfile;
import org.junit.Test;

import static com.viandasya.model.builders.user.ClientProfileBuilder.anyClientProfile;
import static org.junit.Assert.assertEquals;

public class ClientProfileBuilderTest {
    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setName("name")
                .createClientProfile();

        assertEquals(anyClientProfile.getName(), "name");
    }

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder2() {
        ClientProfile anyClientProfile  =  anyClientProfile()
                .setLastName("lastName")
                .createClientProfile();

        assertEquals(anyClientProfile.getLastName(), "lastName");
    }

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder3() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setEmail("email")
                .createClientProfile();

        assertEquals(anyClientProfile.getEmail(), "email");
    }

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder4() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setPhoneNumber(12345)
                .createClientProfile();

        assertEquals(anyClientProfile.getPhoneNumber(), 12345,0);
    }

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder5() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setCity("city")
                .createClientProfile();

        assertEquals(anyClientProfile.getCity(), "city");
    }

    @Test
    public void testIsValid_WhenICanCreateAClientProfileWithServiceClientProfileBuilder6() {
        ClientProfile anyClientProfile  = anyClientProfile()
                .setAdress("adress")
                .createClientProfile();

        assertEquals(anyClientProfile.getAdress(), "adress");
    }
}
