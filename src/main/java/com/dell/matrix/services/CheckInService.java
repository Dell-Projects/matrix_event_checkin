package com.dell.matrix.services;

import com.dell.matrix.configurations.Exceptions.CheckInAlreadyDoneException;
import com.dell.matrix.configurations.Exceptions.CheckInOutOfDateException;
import com.dell.matrix.configurations.Exceptions.EventOutOfCapacityException;
import com.dell.matrix.configurations.Exceptions.RoleNotPermittedInEventException;
import com.dell.matrix.models.Employee;
import com.dell.matrix.models.EmployeeEvent;
import com.dell.matrix.models.Event;
import com.dell.matrix.models.transition.CheckInRequest;
import com.dell.matrix.repositories.EmployeeEventRepository;
import com.dell.matrix.repositories.EmployeesRepository;
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

    EventsRepository eventsRepository;
    EmployeesRepository employeesRepository;
    EmployeeEventRepository employeeEventRepository;

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
        } else if (roleDoesNotMatch(checkin.getEvent().getId(), checkin.getEmployee().getBadge())) {
            throw new RoleNotPermittedInEventException("Employee role not permitted in the event");
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
        Long checkInNumber = employeeEventRepository.getEventCheckinCount(eventId);

        if (checkInNumber < desiredEvent.getCapacity())
            return false;
        else
            return true;
    }

    private Boolean roleDoesNotMatch(Long employeeBadge, Long eventId) {
        // Roles: ('Open', 'Intern', 'Contractor' e 'Badge')

//        Employee employee = employeesRepository.findEmployeeByBadge(employeeBadge);
//        Event event = eventsRepository.findEventById(eventId);
//
//        if (event.getEventTarget() == "Open")
//            return false;
//        else if (employee.getRole() == event.getEventTarget())
//            return false;
//        else
//            return true;
        return false;
    }

    public Long getCheckInByBadge(Long eventId){
        return employeeEventRepository.getEventCheckinCount(eventId);
    }

}
