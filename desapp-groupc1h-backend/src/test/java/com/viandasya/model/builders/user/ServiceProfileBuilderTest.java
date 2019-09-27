package com.viandasya.model.builders.user;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ServiceProfile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.viandasya.model.builders.user.ServiceProfileBuilder.anyServiceProfile;
import static org.junit.Assert.assertEquals;

public class ServiceProfileBuilderTest {


    @Test
    public void testIsValid_WhenICanCreateAServiceProfileWithServiceProfileBuilder() {
        List<Menu> menus = new ArrayList<>();
        ServiceProfile anyServiceProfile = anyServiceProfile()
                .setMenus(menus)
                .setBalance(new Balance(0))
                .createServiceProfile();

        assertEquals(anyServiceProfile.getMenus().size(), 0);
    }

    @Test
    public void testIsValid_WhenICanCreateAServiceProfileWithServiceProfileBuilder2() {
        ServiceProfile anyServiceProfile = anyServiceProfile()
                .setBalance(new Balance(0))
                .createServiceProfile();

        assertEquals(anyServiceProfile.getBalance().getAmount(),0,0 );
    }

}
