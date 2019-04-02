package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.LogUserSms;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LogUserSmsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogUserSms record);

    int insertSelective(LogUserSms record);

    LogUserSms selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM log_user_sms ORDER BY create_date DESC")
    List<LogUserSms> selectList();

    int updateByPrimaryKeySelective(LogUserSms record);

    int updateByPrimaryKey(LogUserSms record);
}