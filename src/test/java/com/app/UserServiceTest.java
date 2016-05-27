package com.app;

import com.app.controller.UserController;
import com.app.domain.User;
import com.app.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by li_sj on 2016/5/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class UserServiceTest {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @Test
    public void testSaveUser() {
        User user = new User("测试1", 12);
        user = userService.saveUser(user);
        log.info("user:"+user);
    }
    @Test
    public void testDeleteUser(){
        userService.deleteUser(5);
    }

    @Test
    public void testFindUserById(){
        userService.findUserById(3);
    }

    @Test
    public void testGetUsersByName(){
        List<User> users = userService.getUsersByName("测试1");
        log.info("users length:"+users.size());
    }

}
