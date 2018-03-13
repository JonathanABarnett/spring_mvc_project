package com.alaythiaproductions.springmvcproject.repositories;

import com.alaythiaproductions.springmvcproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByNameLike(String name);
}
