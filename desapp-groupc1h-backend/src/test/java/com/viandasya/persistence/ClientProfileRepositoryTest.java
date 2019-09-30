package com.viandasya.persistence;

import com.viandasya.model.user.ClientProfile;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.viandasya.model.builders.user.ClientProfileBuilder.anyClientProfile;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientProfileRepositoryTest {

    @Autowired
    private ClientProfileRepository clientProfileRepository;

    @Test
    public void whenFindingCustomerById_thenCorrect() {
        clientProfileRepository.save(anyClientProfile().createClientProfile());

        Assert.assertTrue(clientProfileRepository.findById(7L).isPresent());
    }

    @Test
    public void whenFindingAllCustomers_thenCorrect() {
        clientProfileRepository.save(anyClientProfile().createClientProfile());
        clientProfileRepository.save(anyClientProfile().createClientProfile());

        Assert.assertTrue((clientProfileRepository.findAll() instanceof List));
    }

    @Test
    public void whenSavingCustomer_thenCorrect() {
        clientProfileRepository.save(anyClientProfile()
                .setName("Alberto").setLastName("Segado").createClientProfile());
        ClientProfile clientProfile = clientProfileRepository.findById(7L)
                .orElseGet(() -> (anyClientProfile().createClientProfile()));

        Assert.assertEquals("Alberto", clientProfile.getName());
    }

}