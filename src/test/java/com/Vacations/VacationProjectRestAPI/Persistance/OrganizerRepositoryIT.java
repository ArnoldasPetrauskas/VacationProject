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
    private VacationRepository repository;

    @Test
    public void whenIndividualIsCreated_theyArePersisted(){
        var destination = new Vacation(
                0,
                "title",
                "small description",
                "country",
                "city",
                LocalDate.parse("2000-10-01"),
                LocalDate.parse("2000-10-10"),
                2000.0
        );

        var savedVacation = repository.save(destination);
        var persistedDestination = entityManager.find(Vacation.class, savedVacation.getId());
        assertEquals(persistedDestination, savedVacation);
    }
}
