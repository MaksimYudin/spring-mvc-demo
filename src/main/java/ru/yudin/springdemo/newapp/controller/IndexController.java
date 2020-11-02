package ru.yudin.springdemo.newapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value="")
    public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) {

        return new ModelAndView("redirect:/customer/list");

    }

}
