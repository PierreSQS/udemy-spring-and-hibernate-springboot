package com.luv2code.springboot.chadderbycruddemo.dao;

import com.luv2code.springboot.chadderbycruddemo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
