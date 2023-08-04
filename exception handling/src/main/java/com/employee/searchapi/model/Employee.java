package com.employee.searchapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;


@Entity
@Table(name="emp_table")
@Validated
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    @NotBlank(message = "Employee name required")
    @Size(min = 3, max = 10, message = "Name must have Atleast 3 characters ")
    private String name;

    @Column(name="department")
    @NotBlank(message = "Employee Department is required")
    @Size(min = 5, message = "Department must have atleast 5 characters ")
    private String department;
    @Column(name="designation")
    @NotBlank(message = "designation is required")
    @Size(min = 3, message = "Designation must have atleast 5 characters")

    private String designation;
    @Column(name="email")
    @Email
    private String email;
    @Column(name="salary")
    @Min(19000)
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
