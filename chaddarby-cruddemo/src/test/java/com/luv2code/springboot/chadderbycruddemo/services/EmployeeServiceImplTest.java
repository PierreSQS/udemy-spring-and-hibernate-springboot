package com.luv2code.springboot.chadderbycruddemo.services;

import com.luv2code.springboot.chadderbycruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.chadderbycruddemo.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    EmployeeRepository employeeRepoMock;

    @InjectMocks
    EmployeeServiceImpl employeeSrv;

    private Employee emp1;
    private Employee emp2;

    @BeforeEach
    void setUp() {
        emp1 = new Employee("Pierrot","Mongonnam","mongo@gmail.com");
        emp2 = new Employee("Sarah","Mongonnam","sarah@gmail.com");
    }

    @Test
    void findAll() {
        // Given
        List<Employee> allEmployees = List.of( emp1,emp2);

        // when
        when(employeeRepoMock.findAll()).thenReturn(allEmployees);

        List<Employee> employeeList = employeeSrv.findAll();
        System.out.println("##total employees: "+employeeList.size());

        // Then
        assertThat(employeeList).isNotEmpty().hasSize(2).contains(emp1,emp2);
    }

    @Test
    void findById() {
        when(employeeRepoMock.findById(anyInt())).thenReturn(Optional.ofNullable(emp1));

        Employee foundEmp = employeeSrv.findById(1);

        assertThat(foundEmp).isEqualTo(emp1);
    }

    @Disabled("Not implemented yet")
    @Test
    void save() {
    }

    @Test
    @Disabled("Not implemented yet")
    void deleteById() {
    }
}