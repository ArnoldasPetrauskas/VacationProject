package com.Vacations.VacationProjectRest.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    public Employee() {
    }

    public Employee(String employeeName, String password, String role) {
        this.employeeName = employeeName;
        this.password = password;
        this.role = role;
    }

    @Id
    private Integer id;

    @NonNull
    private String employeeName;

    @NonNull
    private String password;

    @NonNull
    private String role;

    @ManyToMany(mappedBy = "vacationEmployees")
    private Set<Vacation> vacations = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Vacation> getVacations() {
        return vacations;
    }

    public void addVacation(Vacation vacation) {
        this.vacations.add(vacation);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", vacations=" + vacations +
                '}';
    }
}
