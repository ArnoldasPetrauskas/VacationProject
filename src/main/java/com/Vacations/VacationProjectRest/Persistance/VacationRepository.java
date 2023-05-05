package com.Vacations.VacationProjectRest.Persistance;

import com.Vacations.VacationProjectRest.Entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Integer> {
    Vacation findById(int id);
}
