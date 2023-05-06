package com.Vacations.VacationProjectRest.Services;

import com.Vacations.VacationProjectRest.Entities.Vacation;
import com.Vacations.VacationProjectRest.Persistance.VacationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationService {

    private final VacationRepository vacationRepository;

    public VacationService(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }


    public List<Vacation> findAll() {
        return vacationRepository.findAll();
    }

    public Vacation findById(int vacationId) {
        return vacationRepository.findById(vacationId);
    }
    public void save(Vacation vacation){
        vacationRepository.save(vacation);
    }

    public void saveAll(List<Vacation> vacationList){
        vacationRepository.saveAll(vacationList);
    }
}
