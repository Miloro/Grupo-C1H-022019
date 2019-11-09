package com.viandasya.model.builders.user;

import com.viandasya.model.user.ServiceInfo;
import org.junit.Assert;
import org.junit.Test;

import static com.viandasya.model.builders.user.ServiceInfoBuilder.anyServiceInfo;

public class ServiceInfoBuilderTest {

    @Test
    public void testIsValidWhenICanCreateAServiceInfoWithServiceInfoBuilder() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setName("El Rodeo")
                .createServiceInfo();

        Assert.assertEquals(anyServiceInfo.getName(), "El Rodeo");
    }

    @Test
    public void testIsValidWhenICanCreateAServiceInfoWithServiceInfoBuilder2() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setLogo(":)")
                .createServiceInfo();

        Assert.assertEquals(anyServiceInfo.getLogo(), ":)");
    }

    @Test
    public void testIsValidWhenICanCreateAServiceInfoWithServiceInfoBuilder4() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setDescription("Proveemos hamburguesas y papas fritas")
                .createServiceInfo();

        Assert.assertEquals(anyServiceInfo.getDescription(), "Proveemos hamburguesas y papas fritas");
    }

    @Test
    public void testIsValidWhenICanCreateAServiceInfoWithServiceInfoBuilder5() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setWebsite("www.rodeoquilmes.com.ar")
                .createServiceInfo();

        Assert.assertEquals(anyServiceInfo.getWebsite(), "www.rodeoquilmes.com.ar");
    }

    @Test
    public void testIsValidWhenICanCreateAServiceInfoWithServiceInfoBuilder6() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setEMail("rodeoquilmes01@gmail.com")
                .createServiceInfo();

        Assert.assertEquals(anyServiceInfo.geteMail(), "rodeoquilmes01@gmail.com");
    }

    @Test
    public void testIsValidWhenICanCreateAServiceInfoWithServiceInfoBuilder7() {
        ServiceInfo anyServiceInfo = anyServiceInfo()
                .setPhoneNumber(42501324)
                .createServiceInfo();

        Assert.assertEquals(anyServiceInfo.getPhoneNumber(), 42501324,0);
    }

}
