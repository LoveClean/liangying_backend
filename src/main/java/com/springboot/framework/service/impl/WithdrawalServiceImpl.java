package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.User;
import com.springboot.framework.dao.entity.Withdrawal;
import com.springboot.framework.dao.mapper.UserMapper;
import com.springboot.framework.dao.mapper.WithdrawalMapper;
import com.springboot.framework.service.WithdrawalService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import com.springboot.framework.vo.WithdrawalListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WithdrawalServiceImpl implements WithdrawalService {
    @Resource
    private WithdrawalMapper withdrawalMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseEntity<Withdrawal> selectByPrimaryKey(Integer id) {
        return ResponseEntityUtil.success(withdrawalMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Withdrawal> withdrawalList = withdrawalMapper.selectList();
        List<WithdrawalListVO> recordVOList = Lists.newArrayList();
        for (Withdrawal record : withdrawalList) {
            User record3 = userMapper.selectByPrimaryKey(record.getUserId());
            WithdrawalListVO recordVO = new WithdrawalListVO(record, record3);
            recordVOList.add(recordVO);
        }
        PageInfo pageInfo = new PageInfo(withdrawalList);
        pageInfo.setList(recordVOList);

        PageResponseBean page = new PageResponseBean<Withdrawal>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListByUserId(Integer pageNum, Integer pageSize, String userId) {
        PageHelper.startPage(pageNum, pageSize);

        List<Withdrawal> withdrawalList = withdrawalMapper.selectListByUserId(userId);
        List<WithdrawalListVO> recordVOList = Lists.newArrayList();
        for (Withdrawal record : withdrawalList) {
            User record3 = userMapper.selectByPrimaryKey(record.getUserId());
            WithdrawalListVO recordVO = new WithdrawalListVO(record, record3);
            recordVOList.add(recordVO);
        }
        PageInfo pageInfo = new PageInfo(withdrawalList);
        pageInfo.setList(recordVOList);

        PageResponseBean page = new PageResponseBean<Withdrawal>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public ResponseEntity<Integer> selectCount() {
        return ResponseEntityUtil.success(withdrawalMapper.selectCount());
    }

    @Override
    public ResponseEntity<Integer> updateByStatus(Integer id, Byte status, String updateBy) {
        Withdrawal record = new Withdrawal();
        record.setId(id);
        record.setStatus(status);
        record.setUpdateBy(updateBy);
        return ResponseEntityUtil.success(withdrawalMapper.updateByPrimaryKeySelective(record));
    }
}
