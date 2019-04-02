package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.LogUserLogin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LogUserLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogUserLogin record);

    int insertSelective(LogUserLogin record);

    LogUserLogin selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM log_user_login ORDER BY create_date DESC")
    List<LogUserLogin> selectList();

    int updateByPrimaryKeySelective(LogUserLogin record);

    int updateByPrimaryKey(LogUserLogin record);
}