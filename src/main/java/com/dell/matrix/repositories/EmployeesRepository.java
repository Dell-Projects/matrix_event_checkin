package com.dell.matrix.repositories;

import com.dell.matrix.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByBadge(Long badge);
}
