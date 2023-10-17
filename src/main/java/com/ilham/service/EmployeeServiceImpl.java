package com.ilham.service;

import com.ilham.dto.EmployeeRequestDTO;
import com.ilham.dto.EmployeeResponseDTO;
import com.ilham.entity.Employee;
import com.ilham.repository.EmployeeRepository;
import com.ilham.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO request) {
        Date currentdate = new Date();
        Employee savedEmployee = Employee
                .builder()
                .name(request.getName())
                .username(request.getUsername())
                .email(request.getUsername())
                .address(request.getEmail())
                .position(request.getPosition())
                .createdAt(currentdate)
                .build();

        employeeRepository.save(savedEmployee);
        return Mapper.employeeRequestToEmployee(savedEmployee);
    }

    @Override
    public EmployeeResponseDTO updateEmployeeById(Long employeeId, EmployeeRequestDTO request) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id : " + employeeId + " not found"));


        Date currentDate = new Date();
        Employee updateEmployee = Employee
                .builder()
                .id(employeeId)
                .name(request.getName())
                .username(request.getUsername())
                .email(request.getUsername())
                .address(request.getEmail())
                .position(request.getPosition())
                .createdAt(employee.getCreatedAt())
                .updatedAt(currentDate)
                .build();

        employeeRepository.save(updateEmployee);

        return Mapper.employeeRequestToEmployee(updateEmployee);
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id : " + employeeId + " not found"));
        return Mapper.employeeRequestToEmployee(employee);
    }

    @Override
    public List<EmployeeResponseDTO> getListEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(Mapper::employeeRequestToEmployee)
                .collect(Collectors.toList()); // Collect the mapped results into a List
    }

    @Override
    public String deleteEmployeeById(Long employeeId) {
        getEmployeeById(employeeId);
        employeeRepository.deleteById(employeeId);
        return "Successfully delete employee with id: " + employeeId;
    }
}
