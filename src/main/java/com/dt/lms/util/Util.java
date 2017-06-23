package com.dt.lms.util;

import com.dt.lms.domain.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Created by dtjc on 2017/6/22.
 */
public class Util {
    public static User getLoginUser(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        User user = (User)attr.getRequest().getSession().getAttribute(User.USER_ATTR_NAME);
        return user;
    }
}
