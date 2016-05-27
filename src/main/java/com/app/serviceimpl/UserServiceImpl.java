package com.app.serviceimpl;

import com.app.domain.User;
import com.app.repository.UserRepository;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by li_sj on 2016/5/27.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getUsers() {
       return this.userRepository.findAll();
    }
    @Override
    public List<User> getUsersByName(String name) {
        return this.userRepository.findByName(name);
    }

    @Override
    public User findUserById(int id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public void deleteUser(int id) {
       this.userRepository.delete(id);
    }

    @Override
    public User saveUser(User user){
        return this.userRepository.save(user);
    }

}
