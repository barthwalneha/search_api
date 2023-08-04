package com.employee.searchapi.repository;

import com.employee.searchapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:searchTerm%")
    List<Employee> searchByName(@Param("searchTerm") String searchTerm);

    @Query("SELECT e from Employee e WHERE e.department Like %:query%")
    List<Employee> searchByDepartment(@Param("query") String query);

}


