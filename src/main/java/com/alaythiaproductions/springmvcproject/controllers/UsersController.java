package com.alaythiaproductions.springmvcproject.controllers;

import com.alaythiaproductions.springmvcproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String listUsers(Model model, @RequestParam(defaultValue = "") String name){
        model.addAttribute("users", userService.findByName(name));
        return "views/list";
    }
}
