package com.luv2code.springboot.chadderbycruddemo.service;

import com.luv2code.springboot.chadderbycruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.chadderbycruddemo.entities.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    @Transactional
    public Employee findEmployeeByID(Integer empID) {
        Employee foundEmpByID = employeeDAO.findEmployeeByID(empID);
        if (foundEmpByID != null) {
            return foundEmpByID;
        } else {
            throw new RuntimeException("Employee with ID="+empID+" not found!!");
        }
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeByID(Integer empID) {
        employeeDAO.deleteEmployeeByID(empID);
    }
}
