package com.alaythiaproductions.springmvcproject.controllers;

import com.alaythiaproductions.springmvcproject.models.User;
import com.alaythiaproductions.springmvcproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("title", "MVC Registration");
        model.addAttribute("user", new User());
        return "views/registerForm";
    }

    @PostMapping("/register")
    public String processRegisterForm(@Valid User user, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "MVC Registration");
            return "views/registerForm";
        }

        if (userService.doesUserExist(user.getEmail())) {
            model.addAttribute("title", "MVC Registration");
            model.addAttribute("exist", true);
            return "views/registerForm";
        }

        userService.createUser(user);

        return "views/success";
    }
}
