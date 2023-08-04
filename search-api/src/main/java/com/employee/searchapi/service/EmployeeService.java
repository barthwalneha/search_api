package com.employee.searchapi.service;

import com.employee.searchapi.model.Employee;
import com.employee.searchapi.repository.EmployeeRepository;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
import java.util.Date;
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

    public List<Employee> getEmployeesBetweenDateRange(Date startDate, Date endDate, int page, int pageSize) {
        Pageable pagination = PageRequest.of(page,pageSize);
        return employeeRepository.findByDateOfJoiningBetween(startDate, endDate,pagination);
    }

    public Page<Employee> getEmployeesByPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return employeeRepository.findAll(pageable);


    }

}
