package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Withdrawal;
import com.springboot.framework.util.ResponseEntity;
import org.apache.ibatis.annotations.Param;

public interface WithdrawalService {
    ResponseEntity<Withdrawal> selectByPrimaryKey(Integer id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    PageResponseBean selectListByUserId(Integer pageNum, Integer pageSize, String userId);

    ResponseEntity<Integer> selectCount();

    ResponseEntity<Integer> updateByStatus(Integer id, Byte status, String updateBy);
}
