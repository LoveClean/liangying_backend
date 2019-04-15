package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.SysParameter;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysParameterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysParameter record);

    int insertSelective(SysParameter record);

    SysParameter selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM sys_parameter WHERE status != -1 ORDER BY id ASC")
    List<SysParameter> selectList();

    int updateByPrimaryKeySelective(SysParameter record);

    int updateByPrimaryKey(SysParameter record);
}