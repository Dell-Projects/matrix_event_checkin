package com.dell.matrix.Repositories;

import com.dell.matrix.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByBadge(Long badge);
}
