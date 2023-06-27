package com.tutorial.CRM.service;

import com.tutorial.CRM.dao.EmployeeRepository;
import com.tutorial.CRM.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// TODO: implements employee service methods
@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

//    DI

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByFirstNameAsc();
    }

    @Override
    public Employee findById(int theId) {

        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {

            throw new RuntimeException("Did not find -" + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        return employeeRepository.save(theEmployee);

    }

    @Override
    public void deleteById(int theId) {

        employeeRepository.deleteById(theId);

    }

    @Override
    public List<Employee> searchEmployees(String firstName, String lastName) {


        return employeeRepository.findAllByFirstNameContainingOrLastNameContaining(firstName, lastName);

    }

   /*
    @Override
    public List<Employee> searchEmployees(String theSearchName) {

        return employeeRepository.searchEmployeeByFirstName(theSearchName);

    }
*/


}
