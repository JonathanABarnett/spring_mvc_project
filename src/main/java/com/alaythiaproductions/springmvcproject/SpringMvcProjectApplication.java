package com.alaythiaproductions.springmvcproject;

import com.alaythiaproductions.springmvcproject.models.User;
import com.alaythiaproductions.springmvcproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringMvcProjectApplication  implements CommandLineRunner {

    @Autowired
    private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User admin = new User("admin@mail.com", "Admin", "1234");
//		userService.createAdmin(admin);
	}
}
