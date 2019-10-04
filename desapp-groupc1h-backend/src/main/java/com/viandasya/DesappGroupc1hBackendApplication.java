package com.viandasya;

import com.viandasya.model.menu.Menu;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.model.user.User;
import com.viandasya.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.viandasya.model.builders.OrderBuilder.anyOrder;
import static com.viandasya.model.builders.menu.MenuBuilder.anyMenu;
import static com.viandasya.model.builders.user.ClientProfileBuilder.anyClientProfile;
import static com.viandasya.model.builders.user.ServiceProfileBuilder.*;

@SpringBootApplication
public class DesappGroupc1hBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesappGroupc1hBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(UserRepository userRepository){
		return args -> {
			User user1 = new User();
			user1.addClientProfile(anyClientProfile().createClientProfile());
			User savedUser1 = userRepository.save(user1);

			Menu menu = anyMenu().createMenu();
			menu.addOrder(anyOrder().setClient(savedUser1.getClientProfile()).createOrder());

			ServiceProfile service = anyServiceProfile().createServiceProfile();
			service.addMenu(menu);

			ClientProfile clientProfile2 =anyClientProfile().setLastName("Gonzalez")
					.createClientProfile();

			User user = new User();
			user.addClientProfile(clientProfile2);
			user.addServiceProfile(service);

			userRepository.save(user);
		};
	}

}
