package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.LogUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LogUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogUser record);

    int insertSelective(LogUser record);

    LogUser selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM log_user ORDER BY create_date DESC")
    List<LogUser> selectList();

    int updateByPrimaryKeySelective(LogUser record);

    int updateByPrimaryKey(LogUser record);
}