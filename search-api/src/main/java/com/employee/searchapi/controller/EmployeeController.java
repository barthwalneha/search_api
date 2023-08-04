package com.employee.searchapi.controller;

import com.employee.searchapi.model.Employee;
import com.employee.searchapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok("Employee added successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployeesByName(@RequestParam("searchTerm") String searchTerm) {
        List<Employee> employees = employeeService.searchEmployeesByName(searchTerm);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/searchByDepartment")
    public ResponseEntity<List<Employee>> searchEmployeeByDepartment(@RequestParam("q") String query) {
        return ResponseEntity.ok(employeeService.getEmployeesByDepartment(query));
        //throw new NullPointerException();

    }

}


