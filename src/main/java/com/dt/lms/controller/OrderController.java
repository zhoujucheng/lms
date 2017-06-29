package com.dt.lms.controller;

import com.dt.lms.domain.Order;
import com.dt.lms.mapper.OrderMapper;
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
@RequestMapping("/order")
public class OrderController {
    public final static int IN_ORDER = 1;
    public final static int OUT_ORDER = 2;

    @Autowired
    OrderMapper orderMapper;

    @RequestMapping("/inquiryByDate")
    public List<Order> outInquiryByDate(String date, int type){
        Util.checkLogin();
        if (type != IN_ORDER && type != OUT_ORDER){
            throw new InfoException("查询失败,不支持的类型");
        }
        return orderMapper.inquiryByDate(date,type);
    }

    @RequestMapping("orderInquiryByDate")
    public List<Order> inquiryOrderByDate(String date,int type){
        Util.checkLogin();
        if (date == null || date.equals(""))    return null;
        return orderMapper.inquiryByDate(date,type);
    }

    @RequestMapping("orderInquiryById")
    public Order inquiryOrderById(int id){
        Util.checkLogin();
        if (id<=0)  return null;
        return orderMapper.selectByPrimaryKey(id);
    }

}
