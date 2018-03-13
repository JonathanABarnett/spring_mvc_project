package com.alaythiaproductions.springmvcproject.repositories;

import com.alaythiaproductions.springmvcproject.models.Task;
import com.alaythiaproductions.springmvcproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);
}
