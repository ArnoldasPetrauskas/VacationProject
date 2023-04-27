package com.Vacations.VacationProject;

import com.Vacations.VacationProject.Individual.Individual;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VacationProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VacationProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
