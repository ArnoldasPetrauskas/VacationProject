package com.Vacations.VacationProjectRestAPI.Entities;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

    @NonNull
    private Integer id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String role;

    private Set<Vacation> vacations;
}
