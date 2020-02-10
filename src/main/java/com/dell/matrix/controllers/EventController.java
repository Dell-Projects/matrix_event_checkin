package com.dell.matrix.controllers;

import com.dell.matrix.models.Event;
import com.dell.matrix.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EventController {

    EventService eventService;

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/event")
    public Event getEvent(@RequestParam Long id) {
        return eventService.getEvent(id);
    }

    @PostMapping("/event")
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/event")
    public Event setEvent(@RequestBody Event event) {
        return eventService.setEvent(event);
    }

    @DeleteMapping("/event")
    public void deletEvent(@RequestParam Long id) {
        eventService.deletEvent(id);
    }



}
