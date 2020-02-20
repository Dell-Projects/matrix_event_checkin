package com.dell.matrix.services;

import com.dell.matrix.models.Employee;
import com.dell.matrix.repositories.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    EmployeesRepository employeesRepository;

    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeesRepository.findAll(pageable);
    }

    public Optional<Employee> getEmployeeByBadge(Long badge) { return employeesRepository.findById(badge); }

}
