package com.dt.lms.util;

import com.dt.lms.domain.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dtjc on 2017/6/29.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        if (url.endsWith("login.html") || url.endsWith("login") || url.endsWith(".js")){
            return true;
        }
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        User user = (User)attr.getRequest().getSession().getAttribute(User.USER_ATTR_NAME);
        if (user != null){
            return true;
        }
        httpServletResponse.sendRedirect("/lms/login.html");
        return false;
    }

}
