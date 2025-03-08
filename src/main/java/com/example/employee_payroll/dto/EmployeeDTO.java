package com.example.employee_payroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EmployeeDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 1000, message = "Salary must be at least 1000")
    private int salary;

    // Constructor
    public EmployeeDTO(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Default Constructor
    public EmployeeDTO() {
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
