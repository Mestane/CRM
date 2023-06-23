package com.tutorial.CRM.dao;

import com.tutorial.CRM.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> searchAllBy();

}
