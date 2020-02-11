package com.dell.matrix.repositories;

import com.dell.matrix.models.EmployeeEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeEventRepository extends JpaRepository<EmployeeEvent, Long> {

    Optional<EmployeeEvent> findByEmployeeBadgeAndEventId(Long employeeBadge, Long eventId);

    // TODO: Change this query to JSQL query
    @Query(value = "SELECT COUNT(event_id) FROM employee_events WHERE event_id = event_id", nativeQuery = true)
    Long getEventCheckinCount(Long eventId);

}
