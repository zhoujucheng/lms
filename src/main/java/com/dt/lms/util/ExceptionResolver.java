package com.dt.lms.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dtjc on 2017/6/23.
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver {
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof InfoException){
            responseDefault(response,ex);
            return new ModelAndView();
        }
        return super.doResolveException(request, response, handler, ex);
    }

    private void initResponseJson(HttpServletResponse response) {
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");//告诉浏览器,不需要进行缓存
    }

    private void responseDefault(HttpServletResponse response, Exception e) {
        initResponseJson(response);
        try {
            response.getWriter().write(e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
