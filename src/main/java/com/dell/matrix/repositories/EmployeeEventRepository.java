package com.dell.matrix.repositories;

import com.dell.matrix.models.EmployeeEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeEventRepository extends JpaRepository<EmployeeEvent, Long> {

    Optional<EmployeeEvent> findByEmployeeBadgeAndEventId(Long employeeBadge, Long eventId);

//    @Query(value = "SELECT COUNT(e) FROM employee_events e WHERE e.event_id = :eventId", nativeQuery = true)
    Optional<EmployeeEvent> findAllByEventId(Long eventId);

}
