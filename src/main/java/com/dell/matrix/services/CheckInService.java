package com.dell.matrix.services;

import com.dell.matrix.configurations.Exceptions.CheckInAlreadyDoneException;
import com.dell.matrix.configurations.Exceptions.CheckInOutOfDateException;
import com.dell.matrix.configurations.Exceptions.EventOutOfCapacityException;
import com.dell.matrix.models.Employee;
import com.dell.matrix.models.EmployeeEvent;
import com.dell.matrix.models.Event;
import com.dell.matrix.models.Transition.CheckInRequest;
import com.dell.matrix.repositories.EmployeeEventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CheckInService {

    EmployeeEventRepository employeeEventRepository;
    EventService eventService;
    EmployeeService employeeService;

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

        // TODO: Saber a capacity do evento antes de fazer o checkin
        // Opção 1: Ter um campo no modelo 'Event' que armazena a capacity atual do evento ***
        // Opção 2: Fazer uma query para ver quantas pessoas possuem checkin no evento, para saber a capacity

        return false;
    }

}
