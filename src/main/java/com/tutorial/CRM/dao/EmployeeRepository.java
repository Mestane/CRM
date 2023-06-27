package com.tutorial.CRM.dao;

import com.tutorial.CRM.entity.Employee;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //    List<Employee> findAllByOrderByLastNameAsc();
    List<Employee> findAllByOrderByFirstNameAsc();


//    List<Employee> searchEmployeeByFirstName(@NotBlank(message = "Name not be blank") String firstName);

    List<Employee> findAllByFirstNameContainingOrLastNameContaining(@NotBlank(message = "Name not be blank") String firstName, String lastName);


}