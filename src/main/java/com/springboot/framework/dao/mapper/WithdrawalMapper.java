package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.Withdrawal;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WithdrawalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Withdrawal record);

    int insertSelective(Withdrawal record);

    Withdrawal selectByPrimaryKey(Integer id);

    @Select("SELECT * FROM tb_withdrawal ORDER BY status ASC, create_date ASC")
    List<Withdrawal> selectList();

    @Select("SELECT * FROM tb_withdrawal WHERE create_by LIKE CONCAT('%',#{userId},'%') ORDER BY status ASC, create_date ASC")
    List<Withdrawal> selectListByUserId(@Param("userId") String userId);

    @Select("SELECT COUNT(*) FROM tb_withdrawal WHERE `status` != -1")
    int selectCount();

    int updateByPrimaryKeySelective(Withdrawal record);

    int updateByPrimaryKey(Withdrawal record);
}