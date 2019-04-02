package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.LogUserUpdate;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LogUserUpdateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogUserUpdate record);

    int insertSelective(LogUserUpdate record);

    LogUserUpdate selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM log_user_update ORDER BY create_date DESC")
    List<LogUserUpdate> selectList();

    int updateByPrimaryKeySelective(LogUserUpdate record);

    int updateByPrimaryKey(LogUserUpdate record);
}