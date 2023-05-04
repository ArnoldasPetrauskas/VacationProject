package com.Vacations.VacationProjectRestAPI.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "destinations")
public class Destination {

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
}
