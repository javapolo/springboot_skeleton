package com.app.service;

import com.app.domain.User;

import java.util.List;

/**
 * Created by li_sj on 2016/5/27.
 */
public interface UserService {
   public List<User> getUsers();
   public List<User> getUsersByName(String name);
   public User findUserById(int id);
   public void deleteUser(int id);
   public User saveUser(User user);
}
