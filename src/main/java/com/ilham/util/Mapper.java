package com.ilham.util;

import com.ilham.dto.EmployeeResponse;
import com.ilham.entity.Employee;

public class Mapper {

    public static EmployeeResponse employeeRequestToEmployee(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .username(employee.getUsername())
                .email(employee.getEmail())
                .address(employee.getAddress())
                .position(employee.getPosition())
                .createdAt(employee.getCreatedAt())
                .updatedAt(employee.getUpdatedAt())
                .build();
    }
}
