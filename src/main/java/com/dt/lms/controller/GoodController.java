package com.dt.lms.controller;

import com.dt.lms.domain.Good;
import com.dt.lms.mapper.GoodMapper;
import com.dt.lms.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dtjc on 2017/6/22.
 */

@RestController
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodMapper goodMapper;

    @RequestMapping("/query")
    public List<Good> goods(String name){
        if (name == null)   return null;
//        if (Util.getLoginUser() == null)
        List<Good> list = goodMapper.selectByName(name);
        return list;
    }
}
