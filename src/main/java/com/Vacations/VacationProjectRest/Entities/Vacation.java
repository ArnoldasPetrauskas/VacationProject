package com.Vacations.VacationProjectRest.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "vacations")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, unique = true, length = 30)
    private String title;

    @NonNull
    @Column(nullable = false)
    private String description;

    @NonNull
    @Column
    private String country;

    @NonNull
    @Column
    private String city;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate vacationStartDate;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate vacationEndDate;

    @Column
    @NonNull
    private Double price;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organizer_id", nullable = false)
    private Organizer organizer;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "vacation_employees",
            joinColumns = @JoinColumn(name = "vacation_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Employee> vacationEmployees;

    public Vacation() {
    }

    public Vacation(
            String title, String description, String country,
            String city, LocalDate vacationStartDate, LocalDate vacationEndDate, Double price
    ) {
        this.title = title;
        this.description = description;
        this.country = country;
        this.city = city;
        this.vacationStartDate = vacationStartDate;
        this.vacationEndDate = vacationEndDate;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(LocalDate vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public LocalDate getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(LocalDate vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public void addEmployee(Employee employee) {
        vacationEmployees.add(employee);
    }

    public void removeEmployee(int id) {
        this.vacationEmployees
                .stream()
                .filter(
                        e -> e.getId() == id
                )
                .findFirst()
                .ifPresent(
                        employee -> this.vacationEmployees.remove(employee)
                );
    }
}
