package com.dt.lms.mapper;

import com.dt.lms.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    User findUserByName(String name);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}