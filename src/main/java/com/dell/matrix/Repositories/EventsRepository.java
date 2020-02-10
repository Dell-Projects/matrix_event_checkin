package com.dell.matrix.Repositories;

import com.dell.matrix.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Event, Long> {

    Event findEventById(Long id);
}
