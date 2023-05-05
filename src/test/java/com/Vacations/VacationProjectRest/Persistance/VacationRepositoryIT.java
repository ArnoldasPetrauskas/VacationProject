package com.Vacations.VacationProjectRestAPI.Persistance;

import com.Vacations.VacationProjectRestAPI.Entities.Organizer;
import com.Vacations.VacationProjectRestAPI.Entities.Vacation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class VacationRepositoryIT {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private VacationRepository vacationRepository;

    @Test
    public void whenVacationIsCreated_theyArePersisted(){
        var organizer = new Organizer("Organizer");
        var vacation = new Vacation(
                "title",
                "small description",
                "country",
                "city",
                LocalDate.parse("2000-10-01"),
                LocalDate.parse("2000-10-10"),
                2000.0
        );

        organizer.addVacation(vacation);
        organizerRepository.save(organizer);

        var savedVacation = vacationRepository.save(vacation);
        var persistedVacation = entityManager.find(Vacation.class, savedVacation.getId());
        assertEquals(persistedVacation, savedVacation);
    }
}
