package com.alaythiaproductions.springmvcproject.controllers;

import com.alaythiaproductions.springmvcproject.models.Task;
import com.alaythiaproductions.springmvcproject.services.TaskService;
import com.alaythiaproductions.springmvcproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/addTask")
    public String taskForm(Model model, String email, HttpSession session) {

        session.setAttribute("email", email);

        model.addAttribute("title", "Add Task");
        model.addAttribute("task", new Task());

        return "views/taskForm";
    }

    @PostMapping(value = "/addTask")
    public String processTaskForm(@Valid Task task, Errors errors, HttpSession session, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Task");

            return "views/taskForm";
        }
        String email = (String) session.getAttribute("email");
        taskService.addTask(task, userService.findOne(email));

        return "redirect:/users";
    }
}
