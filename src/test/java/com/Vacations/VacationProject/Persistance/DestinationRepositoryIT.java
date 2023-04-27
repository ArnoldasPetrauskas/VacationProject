package com.Vacations.VacationProject.Persistance;

import com.Vacations.VacationProject.Destination.Destination;
import com.Vacations.VacationProject.Individual.Individual;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DestinationRepositoryIT {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DestinationRepository repository;

    @Test
    public void whenIndividualIsCreated_theyArePersisted(){
        var destination = new Destination(
                0,
                "title",
                "small description",
                "country",
                "city",
                LocalDate.parse("2000-10-01"),
                LocalDate.parse("2000-10-10"),
                2000.0
        );

        var savedDestination = repository.save(destination);
        var persistedDestination = entityManager.find(Destination.class, savedDestination.getId());
        assertEquals(persistedDestination, savedDestination);
    }
}
