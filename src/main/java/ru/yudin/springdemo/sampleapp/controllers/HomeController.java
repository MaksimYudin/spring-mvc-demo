package ru.yudin.springdemo.sampleapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("")
    public String showPage() {
        return "main_menu";
    }
}
