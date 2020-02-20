package com.dell.matrix.controllers;

import com.dell.matrix.models.EmployeeEvent;
import com.dell.matrix.models.transition.CheckInRequest;
import com.dell.matrix.services.CheckInService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CheckInController {

    CheckInService checkInService;

    @ApiOperation("Create a CheckIn based on event Id and employee badge")
    @PostMapping("/checkin")
    public EmployeeEvent checkIn(@RequestBody CheckInRequest request) {
        return checkInService.checkInEvents(request);
    }

    @GetMapping("/checkin/{badge}")
    public Long countCheckInByBadge(@PathVariable Long badge) { return checkInService.getCheckInByBadge(badge); }

}
