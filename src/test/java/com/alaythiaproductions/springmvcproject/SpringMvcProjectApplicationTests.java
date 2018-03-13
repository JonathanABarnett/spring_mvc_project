package com.alaythiaproductions.springmvcproject;

import com.alaythiaproductions.springmvcproject.models.Task;
import com.alaythiaproductions.springmvcproject.models.User;
import com.alaythiaproductions.springmvcproject.services.TaskService;
import com.alaythiaproductions.springmvcproject.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMvcProjectApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
    private TaskService taskService;

	@Before
	public void initDb() {
        {
            User newUser = new User("jbarn@gmail.com", "jbarn", "123456");
            userService.createUser(newUser);
        }
        {
            User newAdmin = new User("abarn@gmail.com", "abarn", "123456");
            userService.createAdmin(newAdmin);
        }

        Task userTask = new Task("03/01/2018", "8:30 AM", "5:30 PM", "A Workaholic");
        User user = userService.findOne("jbarn@gmail.com");
        taskService.addTask(userTask, user);
    }

    @Test
    public void testUser() {
	    User user = userService.findOne("jbarn@gmail.com");
	    assertNotNull(user);
	    User admin = userService.findOne("abarn@gmail.com");
	    assertNotNull(admin);
	    assertEquals(admin.getEmail(), ("abarn@gmail.com"));
    }

    @Test
    public void testTask() {
        User user = userService.findOne("jbarn@gmail.com");
        List<Task> task = taskService.findUserTaks(user);
        assertNotNull(task);

    }

}
