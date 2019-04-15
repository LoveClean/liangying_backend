package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Update("UPDATE tb_user SET status = -1, update_by = #{updateBy} WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") String id, @Param("updateBy") String updateBy);

    int insert(User record);

    int insertSelective(User record);

    @Select("SELECT * FROM tb_user WHERE status != -1 AND phone = #{phone}")
    User selectByPhone(@Param("phone") String phone);

    User selectByPrimaryKey(String id);

    @Select("SELECT * FROM tb_user WHERE status != -1 ORDER BY create_date DESC")
    List<User> selectList();

    @Select("SELECT * FROM tb_user WHERE status != -1 AND CONCAT(`phone`,`username`,`id`) LIKE CONCAT('%',#{search},'%') ORDER BY create_date DESC")
    List<User> selectListBySearch(@Param("search") String search);

    @Select("SELECT COUNT(*) FROM tb_user WHERE `status` != -1")
    int selectCount();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}