package com.dell.matrix.services;

import com.dell.matrix.models.Employee;
import com.dell.matrix.repositories.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    EmployeesRepository employeesRepository;

    public List<Employee> getAllEmployees() {
        return employeesRepository.findAll();
    }

    public Optional<Employee> getEmployeeByBadge(Long badge) { return employeesRepository.findById(badge); }

}
