package com.Vacations.VacationProjectRest.Controllers;

import com.Vacations.VacationProjectRest.Entities.Vacation;
import com.Vacations.VacationProjectRest.Persistance.VacationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class VacationsController {

    private final VacationRepository vacationRepository;

    public VacationsController(VacationRepository vacationRepository){
        this.vacationRepository = vacationRepository;
    }

    @GetMapping("/vacations")
    public ResponseEntity<List<Vacation>> vacations() {
        return new ResponseEntity<>(
                vacationRepository.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/vacations/vacation/{vacationId}")
    public ResponseEntity<Vacation> vacationById(@PathVariable int vacationId){
        return new ResponseEntity<>(
                vacationRepository.findById(vacationId),
                HttpStatus.OK
        );
    }
}
