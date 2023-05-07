package com.Vacations.VacationProjectRest.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Table(name = "organizers")
public class Organizer {

    public Organizer() {
    }

    public Organizer(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @OneToMany(mappedBy = "organizer",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Vacation> vacations = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vacation> getVacations() {
        return vacations;
    }

    public void addVacation(Vacation vacation) {
        vacation.setOrganizer(this);
        vacations.add(vacation);
    }

}
