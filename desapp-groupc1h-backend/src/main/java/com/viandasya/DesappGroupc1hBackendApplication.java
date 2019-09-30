package com.viandasya;

import com.viandasya.persistence.ClientProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

import static com.viandasya.model.builders.user.ClientProfileBuilder.anyClientProfile;

@SpringBootApplication
public class DesappGroupc1hBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesappGroupc1hBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(ClientProfileRepository clientProfileRepository){
		return args -> {
			List<String> names = Arrays.asList("Pablo", "Pedro", "Paola", "Patricia", "Patricio", "Pocahontas");
			names.forEach(name ->
					clientProfileRepository.save(anyClientProfile().setName(name).createClientProfile()));
		};
	}

}
