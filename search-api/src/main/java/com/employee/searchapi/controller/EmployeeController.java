package com.employee.searchapi.controller;

import com.employee.searchapi.model.Employee;
import com.employee.searchapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/betweenDates")
    public List<Employee> getEmployeesBetweenDates(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            @RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "size",defaultValue = "2") Integer pageSize) {
        return employeeService.getEmployeesBetweenDateRange(startDate, endDate,pageNumber,pageSize);
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<Employee>> getEmployeesByPage(@RequestParam(defaultValue = "0") int pageNo,
                                                             @RequestParam(defaultValue = "10") int pageSize) {
        Page<Employee> employeesPage = employeeService.getEmployeesByPage(pageNo, pageSize);
        return new ResponseEntity<>(employeesPage, HttpStatus.OK);

    }
}


