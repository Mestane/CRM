package com.tutorial.CRM.rest;

import com.tutorial.CRM.entity.Employee;
import com.tutorial.CRM.exception.EmployeeErrorResponse;
import com.tutorial.CRM.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // TODO: employee service DI
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // TODO: rest controller for CRUD

//    demo rest


    //    list all employees
    @GetMapping("/employees")
    public List<Employee> findAll() {

        return employeeService.findAll();

    }

    //    get employee by id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

/*
        List<Employee> employeeList = employeeService.findAll();

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        if ((employeeId < 0)) {

            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);

        }
*/
        return theEmployee;

    }

//     default spring security username: user
//     default spring security user password:1142be6e-fc84-405a-a221-29e9a8bad54f


    //    add employees
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0);

        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {

            throw new RuntimeException("Employee Id not found " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "delete employee " + employeeId;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        return employeeService.save(theEmployee);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exception) {

        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();

        employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeErrorResponse.setMessage(exception.getMessage());
        employeeErrorResponse.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);

    }
}

