package com.ilham.service;

import com.ilham.dto.EmployeeRequest;
import com.ilham.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    public EmployeeResponse createEmployee(EmployeeRequest request);

    public EmployeeResponse updateEmployeeById(Long employeeId, EmployeeRequest request);

    public EmployeeResponse getEmployeeById(Long employeeId);

    public List<EmployeeResponse> getListEmployee();

    public String deleteEmployeeById(Long employeeId);
}
