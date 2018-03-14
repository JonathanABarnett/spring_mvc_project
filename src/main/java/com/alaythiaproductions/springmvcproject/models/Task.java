package com.alaythiaproductions.springmvcproject.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Please select a date")
    private String date;
    @NotEmpty(message = "Please select a Start Time")
    private String startTime;
    @NotEmpty(message = "Please select a Stop Time")
    private String stopTime;
    @NotEmpty(message = "Please enter a description of the task")
    private String description;
    @ManyToOne
    @JoinColumn(name = "USER_EMAIL") // Will correspond with User Email (being used as ID)
    private User user;

    public Task() {}

    public Task(String date, String startTime, String stopTime, String description) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
    }

    public Task(String date, String startTime, String stopTime, String description, User user) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
