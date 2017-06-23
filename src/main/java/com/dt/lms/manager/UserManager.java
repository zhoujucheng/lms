package com.dt.lms.manager;

import com.dt.lms.domain.User;
import com.dt.lms.imanager.IUserManager;
import com.dt.lms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by dtjc on 2017/6/16.
 */
@Component
public class UserManager implements IUserManager{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(int id) {
        return userMapper.findUserById(id);
    }
}
