package com.Vacations.VacationProjectRest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VacationProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VacationProjectApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
