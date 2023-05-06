package com.Vacations.VacationProjectRest.Vacations;


import com.Vacations.VacationProjectRest.Controllers.VacationsController;
import com.Vacations.VacationProjectRest.Entities.Vacation;
import com.Vacations.VacationProjectRest.Entities.Vacations;
import com.Vacations.VacationProjectRest.Services.VacationService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VacationsControllerTest {

    private final VacationsController vacationsController;

    private final Vacations vacations;

    public VacationsControllerTest() {
        this.vacations = new Vacations(loadTestVacations());
        FakeVacationRepository vacationRepository = new FakeVacationRepository(vacations.getVacations());
        this.vacationsController = new VacationsController(new VacationService(vacationRepository));
    }

    private List<Vacation> loadTestVacations() {

        Vacation vacation1 = new Vacation(
                "Amazon",
                "Massive jungle",
                "Brazil",
                "Brasilia",
                LocalDate.parse("2024-01-01"),
                LocalDate.parse("2024-02-01"),
                1500.0
        );
        vacation1.setId(1);

        Vacation vacation2 = new Vacation(
                "Rafts",
                "By river with rafts",
                "USA",
                "Dallas",
                LocalDate.parse("2023-06-15"),
                LocalDate.parse("2023-07-10"),
                3000.0
        );
        vacation2.setId(2);

        Vacation vacation3 = new Vacation(
                "title",
                "small description",
                "country",
                "city",
                LocalDate.parse("2000-10-01"),
                LocalDate.parse("2000-10-10"),
                2000.0
        );
        vacation2.setId(3);

        return List.of(
                vacation1,
                vacation2,
                vacation3
        );
    }

    @Test
    void retrievesAllVacations(){
        assertEquals(
                vacations,
                vacationsController.vacations().getBody());
        assertEquals(vacationsController.vacations().getStatusCode(), HttpStatus.OK);
    }

    @Test
    void retrievesVacationById(){
        assertEquals(vacations.getVacations().get(0),
                vacationsController.vacationById(1).getBody());
        assertEquals(vacationsController.vacationById(1).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void failsToRetrieveNonExistentVacation(){
        assertThrows(
                NullPointerException.class,
                () -> vacationsController.vacationById(0)
        );
    }
}
