package com.viandasya.model.builders.user;

import com.viandasya.model.user.ServiceInfo;
import org.junit.Test;

import static com.viandasya.model.builders.user.ServiceInfoBuilder.anyServiceInfo;
import static org.junit.Assert.assertEquals;

public class ServiceInfoBuilderTest {

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setName("El Rodeo")
                .createServiceInfo();

        assertEquals(anyServiceInfo.getName(), "El Rodeo");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder2() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setLogo(":)")
                .createServiceInfo();

        assertEquals(anyServiceInfo.getLogo(), ":)");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder3() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setAdress("San Martin 675")
                .createServiceInfo();

        assertEquals(anyServiceInfo.getAdress(), "San Martin 675");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder4() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setDescription("Proveemos hamburguesas y papas fritas")
                .createServiceInfo();

        assertEquals(anyServiceInfo.getDescription(), "Proveemos hamburguesas y papas fritas");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder5() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setWebsite("www.rodeoquilmes.com.ar")
                .createServiceInfo();

        assertEquals(anyServiceInfo.getWebsite(), "www.rodeoquilmes.com.ar");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder6() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setEMail("rodeoquilmes01@gmail.com")
                .createServiceInfo();

        assertEquals(anyServiceInfo.geteMail(), "rodeoquilmes01@gmail.com");
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceInfoWithServiceInfoBuilder7() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setPhoneNumber(42501324)
                .createServiceInfo();

        assertEquals(anyServiceInfo.getPhoneNumber(), 42501324,0);
    }

}
