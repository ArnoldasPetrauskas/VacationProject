package com.Vacations.VacationProjectRestAPI.Persistance;

import com.Vacations.VacationProjectRestAPI.Individual.Individual;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class IndividualRepositoryIT{

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IndividualRepository repository;

    @Test
    public void whenIndividualIsCreated_theyArePersisted(){
        var individual = new Individual(
                0,
                "name",
                "password",
                "USER"
        );

        var savedIndividual = repository.save(individual);
        var persistedIndividual = entityManager.find(Individual.class, savedIndividual.getId());
        assertEquals(persistedIndividual, savedIndividual);
    }
}
