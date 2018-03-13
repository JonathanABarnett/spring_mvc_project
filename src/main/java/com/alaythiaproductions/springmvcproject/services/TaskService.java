package com.alaythiaproductions.springmvcproject.services;

import com.alaythiaproductions.springmvcproject.models.Task;
import com.alaythiaproductions.springmvcproject.models.User;
import com.alaythiaproductions.springmvcproject.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user) {
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserTaks(User user) {
        return taskRepository.findByUser(user);
    }
}
