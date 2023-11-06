package com.ilham.service.impl;

import com.ilham.dto.response.AttendanceResponseDTO;
import com.ilham.dto.response.EmployeeResponseDTO;
import com.ilham.entity.Attendance;
import com.ilham.entity.Employee;
import com.ilham.exception.NotFoundException;
import com.ilham.repository.AttendanceRepository;
import com.ilham.service.AttendanceService;
import com.ilham.service.EmployeeService;
import com.ilham.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeService employeeService;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, EmployeeService employeeService) {
        this.attendanceRepository = attendanceRepository;
        this.employeeService = employeeService;
    }

    @Override
    public AttendanceResponseDTO checkIn(Long employeeId) {
        EmployeeResponseDTO findEmployee = employeeService.getEmployeeById(employeeId);

        Employee employee = Employee.builder()
                .id(findEmployee.getId())
                .name(findEmployee.getName())
                .username(findEmployee.getUsername())
                .email(findEmployee.getEmail())
                .address(findEmployee.getAddress())
                .position(findEmployee.getPosition())
                .build();

        Date curentDate = new Date();

        Attendance checkIn = Attendance.builder()
                .status("Check-in")
                .checkIn(curentDate)
                .employee(employee)
                .build();

        attendanceRepository.save(checkIn);

        return Mapper.attendanceToAttendanceResponse(checkIn);
    }

    @Override
    public AttendanceResponseDTO checkOut(Long employeeId, Long attendanceId) {
        EmployeeResponseDTO findEmployee = employeeService.getEmployeeById(employeeId);
        Attendance checkIn = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new NotFoundException("Attendance not found"));

        Employee employee = Employee.builder()
                .id(findEmployee.getId())
                .name(findEmployee.getName())
                .username(findEmployee.getUsername())
                .email(findEmployee.getEmail())
                .address(findEmployee.getAddress())
                .position(findEmployee.getPosition())
                .build();



        Date curentDate = new Date();
        Attendance checkOut = Attendance.builder()
                .id(checkIn.getId())
                .status("Check-out")
                .checkIn(checkIn.getCheckIn())
                .checkOut(curentDate)
                .employee(employee)
                .build();

        attendanceRepository.save(checkOut);

        return Mapper.attendanceToAttendanceResponse(checkOut);
    }


}
