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
public class OrganizerRepositoryIT {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrganizerRepository repository;

    @Test
    public void whenOrganizerIsCreated_theyArePersisted(){
        var organizer = new Organizer(
               "Organizer"
        );

        var savedOrganizer = repository.save(organizer);
        var persistedOrganizer = entityManager.find(Organizer.class, savedOrganizer.getId());
        assertEquals(persistedOrganizer, savedOrganizer);
    }
}
