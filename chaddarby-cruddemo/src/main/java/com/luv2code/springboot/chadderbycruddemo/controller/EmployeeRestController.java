package com.luv2code.springboot.chadderbycruddemo.controller;

import com.luv2code.springboot.chadderbycruddemo.entities.Employee;
import com.luv2code.springboot.chadderbycruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;

    }

    @GetMapping("employees")
    public List<Employee> getEmployeees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/{empID}")
    public Employee getEmployee(@PathVariable Integer empID) {
        return employeeService.findEmployeeByID(empID);
    }

    @PostMapping("employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return employee;
    }
}
