package com.Vacations.VacationProjectRestAPI.Individual;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "individuals")
public class Individual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @NonNull
    @Column(nullable = false, unique = true)
    private String password;

    @NonNull
    @Column(nullable = false)
    private String role = "USER";

}
