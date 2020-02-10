package com.dell.matrix.Controllers;

import com.dell.matrix.Models.Employee;
import com.dell.matrix.Services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee")
    public Optional<Employee> getEmployee (@RequestParam Long badge) { return employeeService.getEmployeeByBadge(badge); }

}