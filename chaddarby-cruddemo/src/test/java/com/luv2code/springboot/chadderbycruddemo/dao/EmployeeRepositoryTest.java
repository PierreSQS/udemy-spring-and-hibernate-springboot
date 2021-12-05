package com.luv2code.springboot.chadderbycruddemo.dao;

import com.luv2code.springboot.chadderbycruddemo.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    private Employee emp1;
    private Employee emp2;

    @Autowired
    EmployeeRepository employeeRepo;

    @BeforeEach
    void setUp() {
        emp1 = new Employee("Pierrot","Mongonnam","mongo@gmail.com");
        emp2 = new Employee("Sarah","Mongonnam","sarah@gmail.com");
    }

    @Test
    void testSave() {
        Employee savedEmp1 = employeeRepo.save(emp1);
        assertThat(savedEmp1.getFirstName()).isEqualTo("Pierrot");

        employeeRepo.findAll().forEach(System.out::println);

    }

    @Test
    void deleteById() {
        // unnecessary since not output.See code
        // on line48
        // List<Employee> allEmp = employeeRepo.findAll();
        // Is not output
        // allEmp.forEach(System.out::println);
        employeeRepo.save(emp2);
        long countBefore = employeeRepo.count();

        employeeRepo.deleteById(2);
        long countAfter = employeeRepo.count();
        assertThat(countAfter).isLessThan(countBefore);
    }


}