package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;



@Controller
public class HomeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model){
        //First let's create an employee
        Employee employee = new Employee();
        employee.setName("Stephen Bullock");
        employee.setSsn("555-12-1234");

        // Now lts create a laptop
        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("Latitude XL");
        // Add a laptop to the employee
        employee.setLaptop(laptop);

        //Scave the employee to the database.
        employeeRepository.save(employee);

        // grab all the employees from the database and send them to the templates
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";

    }





}
