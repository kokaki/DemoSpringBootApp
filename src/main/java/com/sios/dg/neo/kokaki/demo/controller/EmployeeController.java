package com.sios.dg.neo.kokaki.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sios.dg.neo.kokaki.demo.domain.Employee;
import com.sios.dg.neo.kokaki.demo.repository.EmployeeRepository;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeRepository empRepository;
    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public String index(Model model) {
        List<Employee> emplist=empRepository.findAll();
        model.addAttribute("emplist", emplist);
        return "index2";
    }
}