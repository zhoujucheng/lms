package com.dt.lms.controller;

import com.dt.lms.domain.User;

import com.dt.lms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * Created by dtjc on 2017/6/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserMapper userMapper;

    @RequestMapping("/login")
    public String getUser(String userName,String pwd){
        if (userName == null || userName.equals("") || pwd == null || pwd.equals("")){
            return "用户名或密码不能为空";
        }
        String msg;
        User user = userMapper.findUserByName(userName);
        if (user == null)   msg = "用户名不存在";
        else {
            if (user.getPassword().equals(pwd)){
                ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
                attr.getRequest().getSession().setAttribute(User.USER_ATTR_NAME,user);
                msg = "登录成功";
            }else {
                msg = "用户名或密码错误";
            }
        }
        return msg;
    }

    @RequestMapping("/logOut")
    public boolean logOut(){
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        attr.getRequest().getSession().setAttribute(User.USER_ATTR_NAME,null);
        return true;
    }


}
