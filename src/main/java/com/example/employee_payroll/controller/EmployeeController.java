//package com.example.employee_payroll.controller;
//
//import com.example.employee_payroll.model.Employee;
//
//import com.example.employee_payroll.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/employeepayrollservice")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping("/")
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping("/get/{id}")
//    public Optional<Employee> getEmployeeById(@PathVariable Long id) {
//        return employeeService.getEmployeeById(id);
//    }
//
//    @PostMapping("/create")
//    public Employee createEmployee(@RequestBody Employee employee) {
//        return employeeService.saveEmployee(employee);
//    }
//
//    @PutMapping("/update")
//    public Employee updateEmployee(@RequestBody Employee employee) {
//        return employeeService.saveEmployee(employee);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//    }
//}
//
//package com.example.employee_payroll.controller;
//
//import com.example.employee_payroll.dto.EmployeeDTO;
//import com.example.employee_payroll.model.Employee;
//import com.example.employee_payroll.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/employeepayrollservice")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping("/")
//    public List<EmployeeDTO> getAllEmployees() {
//        return employeeService.getAllEmployees().stream()
//                .map(employee -> new EmployeeDTO(employee.getName(), employee.getSalary()))
//                .collect(Collectors.toList());
//    }
//
//
//    @GetMapping("/get/{id}")
//    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
//        Employee employee = employeeService.getEmployeeById(id);
//        return new EmployeeDTO(employee.getName(), employee.getSalary());
//    }
//
//    @PostMapping("/create")
//    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        return employeeService.saveEmployee(employeeDTO);
//    }
//
//    @PutMapping("/update/{id}")
//    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
//        return employeeService.updateEmployee(id, employeeDTO);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return "Employee deleted successfully";
//    }
//}

package com.example.employee_payroll.controller;

import com.example.employee_payroll.dto.EmployeeDTO;
import com.example.employee_payroll.model.Employee;
import com.example.employee_payroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping("/")
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees().stream()
                .map(employee -> new EmployeeDTO(employee.getName(), employee.getSalary()))
                .collect(Collectors.toList());
    }

    // Get employee by ID
    @GetMapping("/get/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new EmployeeDTO(employee.getName(), employee.getSalary());
    }

    // Create employee
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

    // Update employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    // Delete employee
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}
