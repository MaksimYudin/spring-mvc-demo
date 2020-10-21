package ru.yudin.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping("showForm")
    public String showForm() {

        return "helloworld-form";

    }

    @GetMapping("processForm")
    public String processForm() {

        return "helloworld";

    }

    @GetMapping("processFormVersionTwo")
    public String letsShouteDude(HttpServletRequest request, Model model) {

        String name = request.getParameter("studentName");

        name = name.toUpperCase();

        String message = "HI12 " + name;

        model.addAttribute("message", message);

        return "helloworld";


    }

    @GetMapping("processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name,
                                          Model model) {

        name = name.toUpperCase();

        String message = "Hello " + name;

        model.addAttribute("message", message);

        return "helloworld";

    }
}
