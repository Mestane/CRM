package com.tutorial.CRM.controller;

import com.tutorial.CRM.entity.Employee;
import com.tutorial.CRM.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// TODO: edit employee controllers
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> theEmployee = employeeService.findAll();

        model.addAttribute("employees", theEmployee);

        return "employees/list-employees";

    }

    @GetMapping("/add")
    public String formAdd(Model model) {

        Employee theEmployee = new Employee();

        model.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String formSave(@Valid @ModelAttribute("employee") Employee theEmployee, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            return "employees/employee-form";
        }

        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

}
