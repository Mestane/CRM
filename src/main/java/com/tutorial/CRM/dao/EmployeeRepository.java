package com.tutorial.CRM.dao;

import com.tutorial.CRM.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
