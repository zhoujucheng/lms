package com.dt.lms.util;

import com.dt.lms.domain.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dtjc on 2017/6/22.
 */
public class Util {
    public static void checkLogin(){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        User user = (User)attr.getRequest().getSession().getAttribute(User.USER_ATTR_NAME);
        if (user == null)   throw new InfoException("请先登录");
    }
}
