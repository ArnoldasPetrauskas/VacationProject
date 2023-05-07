package com.Vacations.VacationProjectRest.Persistance;

import com.Vacations.VacationProjectRest.Entities.Organizer;
import com.Vacations.VacationProjectRest.Entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
    Organizer findById(int id);
}
