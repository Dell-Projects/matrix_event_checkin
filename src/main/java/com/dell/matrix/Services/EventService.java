package com.dell.matrix.Services;

import com.dell.matrix.Models.Event;
import com.dell.matrix.Repositories.EventsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService {

    EventsRepository eventsRepository;

    public List<Event> getAllEvents() {
        return eventsRepository.findAll();
    }

    public Event getEvent(Long id) { return eventsRepository.findEventById(id); }

    public Event addEvent(Event event) { return eventsRepository.save(event); }

    public void deletEvent(Long id) {
        eventsRepository.deleteById(id);
    }

    public Event setEvent(Event event) { return eventsRepository.save(event); }
}
