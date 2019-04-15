package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Earn;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EarnMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Earn record);

    int insertSelective(Earn record);

    Earn selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_earn ORDER BY create_date DESC")
    List<Earn> selectList();

    @Select("SELECT COUNT(*) FROM tb_earn")
    int selectCount();

    int updateByPrimaryKeySelective(Earn record);

    int updateByPrimaryKey(Earn record);
}