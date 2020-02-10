package com.dell.matrix.Repositories;

import com.dell.matrix.Models.EmployeeEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface EmployeeEventRepository extends JpaRepository<EmployeeEvent, Long> {

    Optional<EmployeeEvent> findByEmployeeBadgeAndEventId(Long employeeBadge, Long eventId);

//    @Query(value = "SELECT COUNT(e) FROM employee_events e WHERE e.event_id = :eventId", nativeQuery = true)
    Optional<EmployeeEvent> findAllByEventId(Long eventId);

}
