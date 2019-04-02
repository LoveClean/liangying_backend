package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Loan;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.vo.LoanVO;

public interface LoanService {
    ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy);

    ResponseEntity<Loan> selectByPrimaryKey(Integer id);

    ResponseEntity<LoanVO> selectInfoByPrimaryKey(Integer id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    PageResponseBean selectListBySearch(Integer pageNum, Integer pageSize, String search);

    ResponseEntity<Integer> selectCount();

    ResponseEntity<Integer> updateByPrimaryKeySelective(Loan record);

    ResponseEntity<Integer> updateByStatus(Integer id, Byte status, String updateBy);
}
