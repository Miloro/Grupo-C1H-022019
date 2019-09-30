package com.viandasya.webservice;

import com.viandasya.model.user.ClientProfile;
import com.viandasya.persistence.ClientProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClientProfileController {

    private final ClientProfileRepository clientProfileRepository;

    @Autowired
    public ClientProfileController(ClientProfileRepository clientProfileRepository) {
        this.clientProfileRepository = clientProfileRepository;
    }

    @GetMapping("/clients")
    public List<ClientProfile> getCustomers() {
        return (List<ClientProfile>) clientProfileRepository.findAll();
    }

}
