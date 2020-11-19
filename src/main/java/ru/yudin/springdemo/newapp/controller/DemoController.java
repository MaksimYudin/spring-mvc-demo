package ru.yudin.springdemo.newapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/test")
    public String showHome() {
        return "home";
    }
}
