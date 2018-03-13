package com.alaythiaproductions.springmvcproject.services;

import com.alaythiaproductions.springmvcproject.models.Role;
import com.alaythiaproductions.springmvcproject.models.User;
import com.alaythiaproductions.springmvcproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        BCryptPasswordEncoder encorder = new BCryptPasswordEncoder();
        user.setPassword(encorder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public void createAdmin(User user) {
        BCryptPasswordEncoder encorder = new BCryptPasswordEncoder();
        user.setPassword(encorder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }

    public User findOne(String email) {
        return userRepository.findOne(email);
    }

    public boolean doesUserExist(String email) {
        User user = userRepository.findOne(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
