package com.alaythiaproductions.springmvcproject.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @Email
    @NotEmpty(message = "Please enter a valid email address")
    @Column(unique = true)
    private String email;
    @NotEmpty(message = "Please enter your full name")
    private String name;
    @Size(min = 4, message = "Password must be greater than 4 characters")
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // mappedBy name must be the same as what is listed in Task
                                                             // OneToMany is owned by User
    private List<Task> tasks;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email") // References the User email field
    }, inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")}) // References the Role name field
    private List<Role> roles;

    public User() {}

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTask() {
        return tasks;
    }

    public void setTask(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
