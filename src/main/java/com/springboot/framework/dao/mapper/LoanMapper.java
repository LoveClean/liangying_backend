package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Loan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LoanMapper {
    @Update("UPDATE tb_loan SET status = -1, update_by = #{updateBy} WHERE id = #{id}")
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("updateBy") String updateBy);

    int insert(Loan record);

    int insertSelective(Loan record);

    Loan selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_loan WHERE status != -1 ORDER BY create_date DESC")
    List<Loan> selectList();

    @Select("SELECT * FROM tb_loan WHERE status != -1 AND create_by LIKE CONCAT('%',#{search},'%') ORDER BY create_date DESC")
    List<Loan> selectListBySearch(String search);

    @Select("SELECT COUNT(*) FROM tb_loan WHERE `status` != -1")
    int selectCount();

    int updateByPrimaryKeySelective(Loan record);

    int updateByPrimaryKey(Loan record);
}