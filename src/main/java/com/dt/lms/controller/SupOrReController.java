package com.dt.lms.controller;

import com.dt.lms.domain.SupOrRe;
import com.dt.lms.mapper.SupOrReMapper;
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

}
