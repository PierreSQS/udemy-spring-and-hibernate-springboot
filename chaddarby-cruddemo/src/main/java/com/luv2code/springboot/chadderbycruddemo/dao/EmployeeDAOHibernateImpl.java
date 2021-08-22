package com.luv2code.springboot.chadderbycruddemo.dao;

import com.luv2code.springboot.chadderbycruddemo.entities.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{
    private final EntityManager entityManager;

    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAllEmployees() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create and execute the Query
        Query<Employee> employeesQuery = currentSession.createQuery("from Employee", Employee.class);

        // get the result list and return it
        return employeesQuery.getResultList();
    }
}
