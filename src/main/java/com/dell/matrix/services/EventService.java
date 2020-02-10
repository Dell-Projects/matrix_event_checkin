package com.dell.matrix.services;

import com.dell.matrix.models.Event;
import com.dell.matrix.repositories.EventsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    EventsRepository eventsRepository;

    public List<Event> getAllEvents() {
        return eventsRepository.findAll();
    }

    public Event getEventById(Long id) { return eventsRepository.findEventById(id); }

    public Event createEvent(Event event) { return eventsRepository.save(event); }

    public void deleteEvent(Long id) {
        eventsRepository.deleteById(id);
    }

    public Event updateEvent(Event event) { return eventsRepository.save(event); }
}
