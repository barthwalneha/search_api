package com.employee.searchapi.service;

import com.employee.searchapi.model.Employee;
import com.employee.searchapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> searchEmployeesByName(String searchTerm) {
        return employeeRepository.searchByName(searchTerm);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.searchByDepartment(department);

    }
}
