package com.alaythiaproductions.springmvcproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index"})
    public String showIndexPage(Model model) {
        model.addAttribute("title", "MVC Home");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String showLoginPage(Model model) {
        model.addAttribute("title", "Login");
        return "views/loginForm";
    }
}
