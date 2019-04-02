package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Earn;
import org.apache.ibatis.annotations.Select;

public interface EarnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Earn record);

    int insertSelective(Earn record);

    Earn selectByPrimaryKey(Integer id);

    @Select("SELECT COUNT(*) FROM tb_earn WHERE `status` != -1")
    int selectCount();

    int updateByPrimaryKeySelective(Earn record);

    int updateByPrimaryKey(Earn record);
}