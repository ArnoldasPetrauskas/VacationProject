package com.Vacations.VacationProjectRestAPI.Persistance;

import com.Vacations.VacationProjectRestAPI.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
