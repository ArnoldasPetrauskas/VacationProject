package com.Vacations.VacationProjectRest.Controllers;

import com.Vacations.VacationProjectRest.Entities.Vacation;
import com.Vacations.VacationProjectRest.Services.VacationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class VacationsController {

    private final VacationService vacationService;

    public VacationsController(VacationService vacationService){
        this.vacationService = vacationService;
    }

    @GetMapping("/vacations")
    public ResponseEntity<List<Vacation>> vacations() {
        return new ResponseEntity<>(
                vacationService.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/vacations/vacation/{vacationId}")
    public ResponseEntity<Vacation> vacationById(@PathVariable int vacationId){
        return new ResponseEntity<>(
                vacationService.findById(vacationId),
                HttpStatus.OK
        );
    }
}
