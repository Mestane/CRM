package com.tutorial.CRM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


// Demo Controller
@Controller
@RequestMapping("/init")

public class DemoController {

    @GetMapping
    public String initPage(Model model) {

        model.addAttribute("theDate", new Date());

        return "welcome";

    }


}
