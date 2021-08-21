package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomerByID(Long customerID) {
        if (customerID == null){
            return new Customer();
        } else {
            return customerDAO.findByID(customerID);
        }
    }

    @Override
    @Transactional
    public void deleteCustomerByID(Long customerID) {
        customerDAO.deleteCustomerByID(customerID);
    }

}
