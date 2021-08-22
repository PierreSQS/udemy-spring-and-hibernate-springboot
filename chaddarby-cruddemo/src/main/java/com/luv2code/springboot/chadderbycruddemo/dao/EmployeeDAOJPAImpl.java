package com.luv2code.springboot.chadderbycruddemo.dao;

import com.luv2code.springboot.chadderbycruddemo.entities.Employee;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Primary
public class EmployeeDAOJPAImpl implements EmployeeDAO{
    private final EntityManager entityManager;

    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployees() {
        // create Query
        Query allEmployeesQuery = entityManager.createQuery("from Employee");

        // get the result list and return it
        return allEmployeesQuery.getResultList();
    }

    @Override
    public Employee findEmployeeByID(Integer empID) {
        return entityManager.find(Employee.class,empID);
    }

    @Override
    public void saveEmployee(Employee employee) {
        // save or update employee
        Employee empFromDB = entityManager.merge(employee);

        // update with id from DB.. so we can generate id for save and insert
        employee.setId(empFromDB.getId());

    }

    @Override
    public void deleteEmployeeByID(Integer empID) {
        // find employee in the DB
        Employee foundEmployee = entityManager.find(Employee.class, empID);

        // remove only if found
        if (foundEmployee != null)
            entityManager.remove(foundEmployee);
    }
}
