package com.ilham.util;

import com.ilham.dto.EmployeeResponseDTO;
import com.ilham.entity.Employee;

import java.text.ParseException;
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

    public static String convertDateToString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yy");
        String formattedDate = outputDateFormat.format(date);
        return formattedDate;
    }
}
