package com.Vacations.VacationProjectRestAPI.Persistance;

import com.Vacations.VacationProjectRestAPI.Entities.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
}
