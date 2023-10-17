package com.ilham.controller;

import com.ilham.dto.EmployeeRequestDTO;
import com.ilham.dto.EmployeeResponseDTO;
import com.ilham.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeResponseDTO createEmployee(@RequestBody EmployeeRequestDTO request) {
        return employeeService.createEmployee(request);
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployee() {
        return employeeService.getListEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO detailEmployee(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequestDTO request) {
        return employeeService.updateEmployeeById(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return employeeService.deleteEmployeeById(id);
    }
}