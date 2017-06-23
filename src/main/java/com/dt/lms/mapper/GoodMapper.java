package com.dt.lms.mapper;

import com.dt.lms.domain.Good;

import java.util.List;

public interface GoodMapper {

    List<Good> selectByName(String name);

    int deleteByPrimaryKey(Integer id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}