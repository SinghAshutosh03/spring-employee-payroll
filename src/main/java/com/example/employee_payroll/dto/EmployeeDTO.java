package com.example.employee_payroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter  // ✅ Generates Getters
@Setter  // ✅ Generates Setters
@NoArgsConstructor  // ✅ Default Constructor (Required for Serialization)
@AllArgsConstructor  // ✅ Constructor with All Fields
public class EmployeeDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 1000, message = "Salary must be at least 1000")
    private int salary;
}
