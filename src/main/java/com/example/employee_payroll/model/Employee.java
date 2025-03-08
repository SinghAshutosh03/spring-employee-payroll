package com.example.employee_payroll.model;

import com.example.employee_payroll.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "employees")
@Getter  // ✅ Generates Getter Methods
@Setter  // ✅ Generates Setter Methods
@NoArgsConstructor  // ✅ Default Constructor (Required by Hibernate)
@AllArgsConstructor  // ✅ Constructor with All Fields
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int salary;

    // Constructor to initialize Employee from EmployeeDTO
    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
    }
}
