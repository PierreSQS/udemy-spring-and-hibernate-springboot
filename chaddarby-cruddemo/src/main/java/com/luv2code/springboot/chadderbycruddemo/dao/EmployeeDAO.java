package com.luv2code.springboot.chadderbycruddemo.dao;

import com.luv2code.springboot.chadderbycruddemo.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAllEmployees();
}
