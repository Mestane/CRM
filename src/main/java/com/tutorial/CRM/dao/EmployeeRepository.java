package com.tutorial.CRM.dao;

import com.tutorial.CRM.entity.Employee;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //    List<Employee> findAllByOrderByLastNameAsc();
    List<Employee> findAllByOrderByFirstNameAsc();

//    List<Employee> searchAllBy();

    List<Employee> searchEmployeeByFirstName(@NotBlank(message = "Name not be blank") String firstName);


}
