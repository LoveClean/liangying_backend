package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.*;
import com.springboot.framework.dao.mapper.*;
import com.springboot.framework.service.LoanService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import com.springboot.framework.util.StringUtil;
import com.springboot.framework.vo.LoanListVO;
import com.springboot.framework.vo.LoanVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Resource
    private LoanMapper loanMapper;
    @Resource
    private LoanInfoMapper loanInfoMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private EarnMapper earnMapper;
    @Resource
    private SysParameterMapper sysParameterMapper;

    @Override
    public ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy) {
        return ResponseEntityUtil.success(loanMapper.deleteByPrimaryKey(id, updateBy));
    }

    @Override
    public ResponseEntity<Loan> selectByPrimaryKey(Integer id) {
        return ResponseEntityUtil.success(loanMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResponseEntity<LoanVO> selectInfoByPrimaryKey(Integer id) {
        Loan record = loanMapper.selectByPrimaryKey(id);
        LoanInfo record2 = loanInfoMapper.selectByPrimaryKey(id);
        User record3 = userMapper.selectByPrimaryKey(record.getUserId());
        LoanVO recordVO = new LoanVO(record, record2, record3);
        return ResponseEntityUtil.success(recordVO);
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Loan> loanList = loanMapper.selectList();
        List<LoanListVO> loanVOList = Lists.newArrayList();
        for (Loan record : loanList) {
            User record3 = userMapper.selectByPrimaryKey(record.getUserId());
            LoanListVO recordVO = new LoanListVO(record, record3);
            loanVOList.add(recordVO);
        }
        PageInfo pageInfo = new PageInfo(loanList);
        pageInfo.setList(loanVOList);

        PageResponseBean page = new PageResponseBean<Loan>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListBySearch(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);

        List<Loan> loanList = loanMapper.selectListBySearch(search);
        List<LoanListVO> loanVOList = Lists.newArrayList();
        for (Loan record : loanList) {
            User record3 = userMapper.selectByPrimaryKey(record.getUserId());
            LoanListVO recordVO = new LoanListVO(record, record3);
            loanVOList.add(recordVO);
        }
        PageInfo pageInfo = new PageInfo(loanList);
        pageInfo.setList(loanVOList);

        PageResponseBean page = new PageResponseBean<Loan>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public ResponseEntity<Integer> selectCount() {
        return ResponseEntityUtil.success(loanMapper.selectCount());
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(Loan record) {
        return null;
    }

    @Override
    public ResponseEntity<Integer> updateByStatus(Integer id, Byte status, String updateBy) {
        Loan loan = loanMapper.selectByPrimaryKey(id);
        loan.setStatus(status);
        loan.setUpdateBy(updateBy);
        User user = userMapper.selectByPrimaryKey(loan.getUserId());
        String superiorId = user.getUserId();
        if (!StringUtil.isEmpty(superiorId)) {
            SysParameter sysParameter = sysParameterMapper.selectByPrimaryKey(1);
            BigDecimal loanMoney = loan.getMoney();
            BigDecimal percentage = new BigDecimal(sysParameter.getValue());
            BigDecimal earnMoney = percentage.multiply(loanMoney).setScale(2, BigDecimal.ROUND_FLOOR);
            Earn earn = new Earn(superiorId, loan.getUserId(), user.getPhone(), earnMoney, loanMoney, percentage, updateBy);
            earnMapper.insertSelective(earn);
            User superior = userMapper.selectByPrimaryKey(superiorId);
            superior.setBalance(superior.getBalance().add(earnMoney));
            superior.setEarn(superior.getEarn().add(earnMoney));
            userMapper.updateByPrimaryKeySelective(superior);
        }
        return ResponseEntityUtil.success(loanMapper.updateByPrimaryKeySelective(loan));
    }
}
