package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Information;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface InformationMapper {
    @Update("UPDATE tb_information SET status = -1, update_by = #{updateBy} WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_information WHERE status != -1 ORDER BY create_date DESC")
    List<Information> selectList();

    @Select("SELECT * FROM tb_information WHERE status != -1 AND title LIKE CONCAT('%',#{title},'%') ORDER BY create_date DESC")
    List<Information> selectListByTitle(@Param("title") String title);

    @Select("SELECT COUNT(*) FROM tb_information WHERE `status` != -1")
    int selectCount();

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}