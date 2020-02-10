package com.dell.matrix.repositories;

import com.dell.matrix.models.EmployeeEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeEventRepository extends JpaRepository<EmployeeEvent, Long> {

    Optional<EmployeeEvent> findByEmployeeBadgeAndEventId(Long employeeBadge, Long eventId);

//    @Query("select p " +
//            "from Partner p " +
//            "left join Location l on p.name = l.partner " +
//            "where l.partner is null")
    Optional<EmployeeEvent> findAllByEventId(Long eventId);

}
