package com.Vacations.VacationProjectRest.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name = "employees")
public class Employee {

    @Id
    private Integer id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String role = "USER";


}
