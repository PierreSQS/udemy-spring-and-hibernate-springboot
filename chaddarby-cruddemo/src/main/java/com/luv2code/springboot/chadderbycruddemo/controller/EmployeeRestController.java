package com.luv2code.springboot.chadderbycruddemo.controller;

import com.luv2code.springboot.chadderbycruddemo.entities.Employee;
import com.luv2code.springboot.chadderbycruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
