package com.Vacations.VacationProject.Persistance;

import com.Vacations.VacationProject.Destination.Destination;
import com.Vacations.VacationProject.Individual.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Integer> {
}
