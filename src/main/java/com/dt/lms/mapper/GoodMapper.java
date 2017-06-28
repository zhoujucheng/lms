package com.dt.lms.mapper;

import com.dt.lms.domain.Good;
import com.dt.lms.domain.Order;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GoodMapper {

    int addOrder(Order order);

    Good findGoodByName(String name);

    List<Good> searchByName(String name);

    int deleteByPrimaryKey(Integer id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}