package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.entity.LoanInfo;

public interface LoanInfoMapper {
    int deleteByPrimaryKey(Integer loanId);

    int insert(LoanInfo record);

    int insertSelective(LoanInfo record);

    LoanInfo selectByPrimaryKey(Integer loanId);

    int updateByPrimaryKeySelective(LoanInfo record);

    int updateByPrimaryKeyWithBLOBs(LoanInfo record);

    int updateByPrimaryKey(LoanInfo record);
}