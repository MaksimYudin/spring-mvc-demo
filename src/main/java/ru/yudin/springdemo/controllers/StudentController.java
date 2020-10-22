package ru.yudin.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yudin.springdemo.models.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/showForm")
    public String showForm(Model model) {

        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }

    @GetMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {

        System.out.println("student: " + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation";
    }
}
