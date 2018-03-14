package com.alaythiaproductions.springmvcproject.controllers;

import com.alaythiaproductions.springmvcproject.models.User;
import com.alaythiaproductions.springmvcproject.services.TaskService;
import com.alaythiaproductions.springmvcproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/profile")
    public String showProfilePate(Model model, Principal principal) {

        String email = principal.getName();
        User user = userService.findOne(email);

        model.addAttribute("tasks", taskService.findUserTaks(user));
        model.addAttribute("title", "Profile Page " + email);

        return "views/profile";
    }
}
