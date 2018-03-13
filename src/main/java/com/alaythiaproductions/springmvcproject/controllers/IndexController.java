package com.alaythiaproductions.springmvcproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String showIndexPage(Model model) {
        model.addAttribute("title", "MVC Home");
        return "index";
    }
}
