package com.alaythiaproductions.springmvcproject.repositories;

import com.alaythiaproductions.springmvcproject.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
