package com.ilham.controller;

import com.ilham.dto.request.AttendanceRequestDTO;
import com.ilham.dto.response.AttendanceResponseDTO;
import com.ilham.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendance")
@CrossOrigin
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("/checkIn/employee/{employeeId}")
    public AttendanceResponseDTO checkIn(@PathVariable("employeeId") Long employeeId) {
        return attendanceService.checkIn(employeeId);
    }

    @PostMapping("/checkOut/employee/{employeeId}/attendance/{attendanceId}")
    public AttendanceResponseDTO checkOut(@PathVariable("employeeId") Long employeeId,@PathVariable("attendanceId") Long AttendanceId) {
        return attendanceService.checkOut(employeeId,AttendanceId);
    }
}
