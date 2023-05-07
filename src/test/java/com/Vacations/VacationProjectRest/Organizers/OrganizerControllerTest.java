package com.Vacations.VacationProjectRest.Organizers;


import com.Vacations.VacationProjectRest.Controllers.OrganizerController;
import com.Vacations.VacationProjectRest.Entities.Organizer;
import com.Vacations.VacationProjectRest.Entities.Organizers;
import com.Vacations.VacationProjectRest.Entities.Vacation;
import com.Vacations.VacationProjectRest.Entities.Vacations;
import com.Vacations.VacationProjectRest.Services.OrganizerService;
import com.Vacations.VacationProjectRest.Vacations.FakeVacationRepository;
import com.Vacations.VacationProjectRest.Vacations.VacationsControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrganizerControllerTest {

    private final OrganizerController organizerController;

    private final Vacations vacations;
    private final Organizers organizers;

    public OrganizerControllerTest() {
        this.vacations = new Vacations(
                new VacationsControllerTest()
                        .loadTestVacations());
        new FakeVacationRepository(vacations.getVacations());
        this.organizers = new Organizers(loadTestOrganizers(vacations.getVacations()));
        FakeOrganizerRepository organizerRepository = new FakeOrganizerRepository(organizers.getOrganizers());
        this.organizerController = new OrganizerController(new OrganizerService(organizerRepository));
    }

    public List<Organizer> loadTestOrganizers(List<Vacation> vacationList) {

        Organizer organizer1 = new Organizer("Test");
        organizer1.setId(1);
        organizer1.addVacation(vacationList.get(0));

        Organizer organizer2 = new Organizer("Bestye");
        organizer2.setId(2);
        organizer2.addVacation(vacationList.get(1));

        Organizer organizer3 = new Organizer("Resti");
        organizer3.setId(3);
        organizer3.addVacation(vacationList.get(2));


        return List.of(
                organizer1,
                organizer2,
                organizer3
        );
    }

    @Test
    void retrievesAllOrganizers(){
        assertEquals(
                organizers,
                organizerController.organizers().getBody());
        assertEquals(organizerController.organizers().getStatusCode(), HttpStatus.OK);
    }

    @Test
    void retrievesOrganizerById(){
        assertEquals(organizers.getOrganizers().get(0),
                organizerController.vacationById(1).getBody());
        assertEquals(organizerController.vacationById(1).getStatusCode(), HttpStatus.OK);
    }

    @Test
    void failsToRetrieveNonExistentOrganizer(){
        assertThrows(
                IllegalArgumentException.class,
                () -> organizerController.vacationById(0)
        );
    }
}
