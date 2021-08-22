package com.luv2code.springboot.chadderbycruddemo.service;

import com.luv2code.springboot.chadderbycruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.chadderbycruddemo.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findEmployeeByID(Integer empID) {
        Optional<Employee> empByIDOpt = employeeDAO.findById(empID);

        return empByIDOpt.orElseThrow(() ->
                new RuntimeException("Employee with ID="+empID+" not found!!")
        );
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public void deleteEmployeeByID(Integer empID) {
        // find Employee by ID
        var foundEmployee = employeeDAO.findById(empID).orElseThrow(
                () -> new RuntimeException("Employee with ID=" + empID + " not found!!")
        );
        employeeDAO.deleteById(foundEmployee.getId());
    }
}
