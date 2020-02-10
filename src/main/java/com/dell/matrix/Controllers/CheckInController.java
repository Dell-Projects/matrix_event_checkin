package com.dell.matrix.Controllers;

import com.dell.matrix.Models.EmployeeEvent;
import com.dell.matrix.Models.Transition.CheckInRequest;
import com.dell.matrix.Services.CheckInService;
import com.dell.matrix.Services.EmployeeService;
import com.dell.matrix.Services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CheckInController {

    CheckInService checkInService;

    @PostMapping("/checkin")
    public EmployeeEvent checkIn(@RequestBody CheckInRequest request) {
        return checkInService.checkInEvents(request);
    }
}
