package com.app.controller;

import com.app.domain.User;
import com.app.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by li_sj on 2016/5/26.
 */
@RestController
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * get  /users/10  获取id为10的用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    User findUser(@PathVariable int userId) {
        return this.userService.findUserById(userId);
    }

    /**
     * get  /users/10  更新id为10的用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
    User updateUser(@PathVariable int userId, @RequestBody User user) {
        User currentUser = this.userService.findUserById(userId);
        if (currentUser == null){
             return null;
        }
        currentUser.setAge(user.getAge());
        currentUser.setName(user.getName());

        return this.userService.saveUser(currentUser);
    }

    /**
     * delete /user/11  删除编号为11的用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    User deleteUser(@PathVariable int userId) {
        User currentUser = this.userService.findUserById(userId);
        if (currentUser == null){
            return null;
        }
        this.userService.deleteUser(userId);
        return currentUser;
    }

    /**
     * post /users  新增用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    User addUser(@RequestBody User user) {
        user = this.userService.saveUser(user);
        return user;
    }

    /**
     * get /users  获取所有的用户信息
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.getUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    /**
     * 获取用户列表页面
     * @return
     */
    @RequestMapping(value = "/usersPage", method = RequestMethod.GET)
    ModelAndView homePage() {
        List<User> users = this.userService.getUsers();
        Map<String,List<User>> pageData = new HashMap<>();
        pageData.put("users", users);
        ModelAndView page = new ModelAndView("home", pageData);
        return page;
    }
}

