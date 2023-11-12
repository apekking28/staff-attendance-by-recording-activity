package com.ilham.util;

import com.ilham.dto.response.AttendanceResponseDTO;
import com.ilham.dto.response.EmployeeResponseDTO;
import com.ilham.entity.Attendance;
import com.ilham.entity.Employee;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mapper {

    public static EmployeeResponseDTO employeeRequestToEmployee(Employee employee) {
        return EmployeeResponseDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .username(employee.getUsername())
                .email(employee.getEmail())
                .address(employee.getAddress())
                .position(employee.getPosition())
                .createdAt(convertDateToString(employee.getCreatedAt()))
                .updatedAt(convertDateToString(employee.getUpdatedAt()))
                .build();
    }

    public static AttendanceResponseDTO attendanceToAttendanceResponse(Attendance attendance) {
        // convert checkIn to date & hour
        String checkInDate = convertDateToString(attendance.getCheckIn());
        String checkInHour = convertDateToHour(attendance.getCheckIn());

        // convert checkOut to hour
        String checkOutHour = convertDateToHour(attendance.getCheckOut());


        return AttendanceResponseDTO.builder()
                .id(attendance.getId())
                .status(attendance.getStatus())
                .checkInDate(checkInDate)
                .checkInHour(checkInHour)
                .checkOutHour(checkOutHour)
                .employee(attendance.getEmployee())
                .build();
    }

    public static String convertDateToString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yy");
        return outputDateFormat.format(date);
    }


    public static String convertDateToHour(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = formatHour.format(date);

        return formattedTime;
    }
}
