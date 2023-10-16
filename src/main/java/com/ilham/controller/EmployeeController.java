package com.ilham.controller;

import com.ilham.dto.EmployeeRequest;
import com.ilham.dto.EmployeeResponse;
import com.ilham.entity.Employee;
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
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @GetMapping
    public List<EmployeeResponse> getAllEmployee() {
        return employeeService.getListEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeResponse detailEmployee(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponse updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequest request) {
        return employeeService.updateEmployeeById(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        return employeeService.deleteEmployeeById(id);
    }
}