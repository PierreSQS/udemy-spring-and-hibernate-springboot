package com.luv2code.springboot.chadderbycruddemo.service;

import com.luv2code.springboot.chadderbycruddemo.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee findEmployeeByID(Integer empID);

    Employee saveEmployee(Employee employee);

    void deleteEmployeeByID(Integer empID);
}
