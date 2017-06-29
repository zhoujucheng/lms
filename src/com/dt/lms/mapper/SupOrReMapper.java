package com.dt.lms.mapper;

import com.dt.lms.domain.SupOrRe;

public interface SupOrReMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SupOrRe record);

    int insertSelective(SupOrRe record);

    SupOrRe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupOrRe record);

    int updateByPrimaryKeyWithBLOBs(SupOrRe record);

    int updateByPrimaryKey(SupOrRe record);
}