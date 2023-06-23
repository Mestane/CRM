package com.tutorial.CRM.service;

import com.tutorial.CRM.entity.Employee;

import java.util.List;

// TODO: add service methods here
public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);


}
