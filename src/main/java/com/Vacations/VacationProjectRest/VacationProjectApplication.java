package com.Vacations.VacationProjectRest;

import com.Vacations.VacationProjectRest.Entities.Organizer;
import com.Vacations.VacationProjectRest.Entities.Vacation;
import com.Vacations.VacationProjectRest.Services.OrganizerService;
import com.Vacations.VacationProjectRest.Services.VacationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class VacationProjectApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    OrganizerService organizerService;

    @Autowired
    VacationService vacationService;

    public static void main(String[] args) {
        SpringApplication.run(VacationProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        populate();
    }

    void populate() {
        List<Vacation> vacations = initVacations();
        Set<Organizer> organizers = initOrganizers(vacations);
        organizerService.saveAll(organizers);
        vacationService.saveAll(vacations);
    }

    private List<Vacation> initVacations() {
        Vacation vacation1 = new Vacation(
                "Amazon",
                "Massive jungle",
                "Brazil",
                "Brasilia",
                LocalDate.parse("2024-01-01"),
                LocalDate.parse("2024-02-01"),
                1500.0
        );

        Vacation vacation2 = new Vacation(
                "Rafts",
                "By river with rafts",
                "USA",
                "Dallas",
                LocalDate.parse("2023-06-15"),
                LocalDate.parse("2023-07-10"),
                3000.0
        );

        Vacation vacation3 = new Vacation(
                "title",
                "small description",
                "country",
                "city",
                LocalDate.parse("2000-10-01"),
                LocalDate.parse("2000-10-10"),
                2000.0
        );

        return List.of(
                vacation1,
                vacation2,
                vacation3
        );
    }

    private Set<Organizer> initOrganizers( List<Vacation> vacationList) {
        Organizer organizer1 = new Organizer("Testtour");
        organizer1.addVacation(vacationList.get(0));

        Organizer organizer2 = new Organizer("Horizons");
        organizer2.addVacation(vacationList.get(1));

        Organizer organizer3 = new Organizer("Traveltour");
        organizer3.addVacation(vacationList.get(2));

        return Set.of(
                organizer1,
                organizer2,
                organizer3
        );
    }
}
