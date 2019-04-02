package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.LogAdmin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LogAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogAdmin record);

    int insertSelective(LogAdmin record);

    LogAdmin selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM log_admin ORDER BY create_date DESC")
    List<LogAdmin> selectList();

    int updateByPrimaryKeySelective(LogAdmin record);

    int updateByPrimaryKey(LogAdmin record);
}