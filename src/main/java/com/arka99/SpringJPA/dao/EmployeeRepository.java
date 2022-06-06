package com.arka99.SpringJPA.dao;

import com.arka99.SpringJPA.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findAll();
    List<Employee> findEmployeeByNameIgnoreCase(String string);
    List<Employee> findEmployeeByAddressIgnoreCase(String string);
    List<Employee> findEmployeeByEmail(String string);
}
