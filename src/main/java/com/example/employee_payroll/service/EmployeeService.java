//package com.example.employee_payroll.service;
//import com.example.employee_payroll.model.Employee;
//import com.example.employee_payroll.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeService {
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
//
//    public Optional<Employee> getEmployeeById(Long id) {
//        return employeeRepository.findById(id);
//    }
//
//    public Employee saveEmployee(Employee employee) {
//        return employeeRepository.save(employee);
//    }
//
//    public void deleteEmployee(Long id) {
//        employeeRepository.deleteById(id);
//    }
//}
package com.example.employee_payroll.service;

import com.example.employee_payroll.dto.EmployeeDTO;
import com.example.employee_payroll.model.Employee;
import com.example.employee_payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Fetch all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Fetch employee by ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // Save a new employee
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO);
        return employeeRepository.save(employee);
    }

    // Update existing employee
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    // Delete employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
