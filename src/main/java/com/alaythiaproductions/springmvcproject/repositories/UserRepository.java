package com.alaythiaproductions.springmvcproject.repositories;

import com.alaythiaproductions.springmvcproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
