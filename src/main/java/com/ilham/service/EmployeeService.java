package com.ilham.service;

import com.ilham.dto.EmployeeRequestDTO;
import com.ilham.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request);

    public EmployeeResponseDTO updateEmployeeById(Long employeeId, EmployeeRequestDTO request);

    public EmployeeResponseDTO getEmployeeById(Long employeeId);

    public List<EmployeeResponseDTO> getListEmployee();

    public String deleteEmployeeById(Long employeeId);
}
