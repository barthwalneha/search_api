package com.employee.searchapi.controller;

import com.employee.searchapi.model.Employee;
import com.employee.searchapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://localhost:3000")

@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployeesByName(@RequestParam("searchTerm") String searchTerm) {
        List<Employee> employees = employeeService.searchEmployeesByName(searchTerm);
        return ResponseEntity.ok(employees);
    }
}
