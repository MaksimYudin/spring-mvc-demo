package ru.yudin.springdemo.newapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yudin.springdemo.newapp.dao.CustomerDAO;
import ru.yudin.springdemo.newapp.entity.Customer;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/list")
    public String listCustomers(Model model) {

        List<Customer> customers = customerDAO.getCustomers();

        model.addAttribute("customers", customers);

        return "list-customers";

    }
}
