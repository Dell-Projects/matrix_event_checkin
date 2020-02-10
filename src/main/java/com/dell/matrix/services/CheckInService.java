package com.dell.matrix.services;

import com.dell.matrix.configurations.Exceptions.CheckInAlreadyDoneException;
import com.dell.matrix.configurations.Exceptions.CheckInOutOfDateException;
import com.dell.matrix.configurations.Exceptions.EventOutOfCapacityException;
import com.dell.matrix.models.Employee;
import com.dell.matrix.models.EmployeeEvent;
import com.dell.matrix.models.Event;
import com.dell.matrix.models.transition.CheckInRequest;
import com.dell.matrix.repositories.EmployeeEventRepository;
import com.dell.matrix.repositories.EventsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CheckInService {

    EventService eventService;
    EmployeeService employeeService;
    EmployeeEventRepository employeeEventRepository;
    EventsRepository eventsRepository;

    public EmployeeEvent checkInEvents(CheckInRequest request) {

        Optional<Event> event = Optional.ofNullable(eventService.getEventById(request.getEventId()));
        Optional<Employee> employee = employeeService.getEmployeeByBadge(request.getEmployeeBadge());

        EmployeeEvent checkin = new EmployeeEvent();

        checkin.setEvent(event.get());
        checkin.setEmployee(employee.get());
        checkin.setCheckinDate(LocalDateTime.now());

        if(isAlreadyCheckedIn(checkin.getEmployee().getBadge(), checkin.getEvent().getId())) {
            throw new CheckInAlreadyDoneException("This person has already checked in");
        } else if (isOutOfDate(checkin.getEvent().getFinalDate())) {
            throw new CheckInOutOfDateException("Check in was made after the event finished");
        } else if (isOutOfCapacity(checkin.getEvent().getId())) {
            throw new EventOutOfCapacityException("Cannot check in because the event has reached it's capacity");
        }

        return employeeEventRepository.save(checkin);
    }

    private Boolean isAlreadyCheckedIn(Long employeeBadge, Long eventId) {
        Optional<EmployeeEvent> response = employeeEventRepository.findByEmployeeBadgeAndEventId(employeeBadge, eventId);

        if (response.isEmpty())
            return false;
        else
            return true;
    }

    private Boolean isOutOfDate(LocalDateTime finalDate) {
        if (LocalDateTime.now().isBefore(finalDate))
            return false;
        else
            return true;
    }

    private Boolean isOutOfCapacity(Long eventId) {
        Event desiredEvent = eventsRepository.findEventById(eventId);

        if (desiredEvent.getCurrentCapacity() < desiredEvent.getMaxCapacity()) {
            desiredEvent.setCurrentCapacity(desiredEvent.getCurrentCapacity() + 1);
            eventsRepository.save(desiredEvent);
            return false;
        }
        else
            return true;
    }

}
