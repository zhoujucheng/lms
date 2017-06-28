package com.dt.lms.controller;

import com.dt.lms.domain.SupOrRe;
import com.dt.lms.mapper.SupOrReMapper;
import com.dt.lms.util.InfoException;
import com.dt.lms.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dtjc on 2017/6/27.
 */
@RestController
@RequestMapping("/supOrRe")
public class SupOrReController {
    @Autowired
    SupOrReMapper supOrReMapper;

    @RequestMapping("/inquiryByType")
    public List<SupOrRe> inquiryByType(int type){
        Util.checkLogin();
        return supOrReMapper.inquiryByType(type);
    }

    @RequestMapping("/add")
    public String add(int number,String name,String address,String tel,String url){
        if (number < 0 || name == null || address == null || tel == null
                || name.equals("") || address.equals("") || tel.equals("")){
            return "输入有误";
        }
        SupOrRe supOrRe = supOrReMapper.selectByPrimaryKey(number);
        if (supOrRe != null){
            return "供应商编号已存在";
        }else{
            supOrRe = new SupOrRe(number,name,tel,address,url,1);
            int status = supOrReMapper.insert(supOrRe);
            if (status == 1){
                return "添加成功";
            }else {
                return "添加失败";
            }
        }
    }
}
