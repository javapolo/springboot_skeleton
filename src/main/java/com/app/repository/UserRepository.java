package com.app.repository;

import com.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by li_sj on 2016/5/27.
 */
public interface UserRepository  extends JpaRepository<User,Integer> {
    List<User> findByName(String name);
}
