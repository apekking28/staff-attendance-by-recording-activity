package com.ilham.service;

import com.ilham.dto.request.EmployeeRequestDTO;
import com.ilham.dto.response.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO request);

    EmployeeResponseDTO updateEmployeeById(Long employeeId, EmployeeRequestDTO request);

    EmployeeResponseDTO getEmployeeById(Long employeeId);

    List<EmployeeResponseDTO> getListEmployee();

    String deleteEmployeeById(Long employeeId);
}
