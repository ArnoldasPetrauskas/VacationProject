package com.Vacations.VacationProjectRestAPI.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name = "organizers")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, unique = true, length = 30)
    private String name;

    @OneToMany(mappedBy = "organizer",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Vacation> vacations =new HashSet<>();

    public void addVacation(Vacation vacation){
        vacations.add(vacation);
        vacation.setOrganizer(this);
    }
}
