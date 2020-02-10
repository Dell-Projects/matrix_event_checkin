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

    public Event updateEvent(Long id, Event event) {
        Event currentEvent = eventsRepository.findEventById(id);
        currentEvent.setMaxCapacity(event.getMaxCapacity());
        currentEvent.setDate(event.getDate());
        currentEvent.setDescription(event.getDescription());
        currentEvent.setEmployeeEvents(event.getEmployeeEvents());
        currentEvent.setFinalDate(event.getFinalDate());
        currentEvent.setHasGift(event.getHasGift());
        return eventsRepository.save(currentEvent);
    }

    public void deleteEvent(Long id) {
        eventsRepository.deleteById(id);
    }

}
