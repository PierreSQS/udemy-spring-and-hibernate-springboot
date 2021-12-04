package com.luv2code.springboot.chadderbycruddemo.services;

import com.luv2code.springboot.chadderbycruddemo.entities.Employee;

import java.util.List;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
