package com.Vacations.VacationProjectRestAPI.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, unique = true, length = 30)
    private String customerName;

    @NonNull
    @Column(nullable = false, unique = true)
    private String password;

    @NonNull
    @Column(nullable = false)
    private String role = "USER";

}
