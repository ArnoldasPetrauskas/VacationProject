package com.Vacations.VacationProjectRest.Controllers;

import com.Vacations.VacationProjectRest.Entities.Organizer;
import com.Vacations.VacationProjectRest.Entities.Organizers;
import com.Vacations.VacationProjectRest.Services.OrganizerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrganizerController {

    private final OrganizerService organizerService;

    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @GetMapping("/organizers")
    public ResponseEntity<Organizers> organizers() {
        return new ResponseEntity<>(
                new Organizers(organizerService.findAll()),
                HttpStatus.OK
        );
    }

    @GetMapping("/organizers/organizer/{organizerId}")
    public ResponseEntity<Organizer> vacationById(@PathVariable int organizerId){
        return new ResponseEntity<>(
                organizerService.findById(organizerId),
                HttpStatus.OK
        );
    }
}
