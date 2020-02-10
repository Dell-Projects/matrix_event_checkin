package com.dell.matrix.Services;

import com.dell.matrix.Configurations.Exceptions.CheckInAlreadyDoneException;
import com.dell.matrix.Configurations.Exceptions.CheckInOutOfDateException;
import com.dell.matrix.Configurations.Exceptions.EventNotFoundException;
import com.dell.matrix.Configurations.Exceptions.EventOutOfCapacityException;
import com.dell.matrix.Models.Employee;
import com.dell.matrix.Models.EmployeeEvent;
import com.dell.matrix.Models.Event;
import com.dell.matrix.Models.Transition.CheckInRequest;
import com.dell.matrix.Repositories.EmployeeEventRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CheckInService {

    EmployeeEventRepository employeeEventRepository;
    EventService eventService;
    EmployeeService employeeService;

    public EmployeeEvent checkInEvents(CheckInRequest request) {

        Optional<Event> event = Optional.ofNullable(eventService.getEvent(request.getEventId()));
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
//        Optional<EmployeeEvent> response = employeeEventRepository.findAllByEventId(eventId);
//        System.out.println("Response: " + response);
        return false;
    }
}
