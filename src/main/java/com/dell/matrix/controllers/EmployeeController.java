package com.dell.matrix.controllers;

import com.dell.matrix.models.Employee;
import com.dell.matrix.services.EmployeeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    @ApiOperation("Get all employees")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @ApiOperation("Get a employee by his badge")
    @GetMapping("/employees/{badge}")
    public Optional<Employee> getEmployeeByBadge(@PathVariable Long badge) { return employeeService.getEmployeeByBadge(badge); }

}