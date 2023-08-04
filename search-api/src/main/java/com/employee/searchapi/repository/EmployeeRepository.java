package com.employee.searchapi.repository;

import com.employee.searchapi.model.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:searchTerm%")
    List<Employee> searchByName(@Param("searchTerm") String searchTerm);

    @Query("SELECT e from Employee e WHERE e.department Like %:query%")
    List<Employee> searchByDepartment(@Param("query") String query);

    @Query("SELECT e FROM Employee e WHERE dateOfJoining BETWEEN :startDate AND :endDate")
    List<Employee> findByDateOfJoiningBetween(Date startDate, Date endDate, Pageable pageable);

}


