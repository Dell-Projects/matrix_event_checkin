package com.dell.matrix.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    private Long badge;

    private String name;

    private String role;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private Set<EmployeeEvent> employeeEvents = new HashSet<>();

}
