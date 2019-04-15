package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.*;
import com.springboot.framework.dao.mapper.*;
import com.springboot.framework.service.LogService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class LogServiceImpl implements LogService {
    @Resource
    private LogAdminMapper logAdminMapper;
    @Resource
    private LogUserLoginMapper logUserLoginMapper;
    @Resource
    private LogUserMapper logUserMapper;
    @Resource
    private LogUserSmsMapper logUserSmsMapper;
    @Resource
    private LogUserUpdateMapper logUserUpdateMapper;
    @Resource
    private EarnMapper earnMapper;

    @Override
    public ResponseEntity<Integer> insertSelective(LogAdmin record) {
        int resultCount = logAdminMapper.insertSelective(record);
        if (resultCount == 0) {
            return ResponseEntityUtil.fail("日志添加失败");
        }
        return ResponseEntityUtil.success(resultCount);
    }

    @Override
    public PageResponseBean selectListForLogAdmin(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<LogAdmin> logList = logAdminMapper.selectList();
        PageInfo pageInfo = new PageInfo(logList);
        pageInfo.setList(logList);

        PageResponseBean page = new PageResponseBean<LogAdmin>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListForLogUserLogin(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<LogUserLogin> logList = logUserLoginMapper.selectList();
        PageInfo pageInfo = new PageInfo(logList);
        pageInfo.setList(logList);

        PageResponseBean page = new PageResponseBean<LogUserLogin>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListForLogUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<LogUser> logList = logUserMapper.selectList();
        PageInfo pageInfo = new PageInfo(logList);
        pageInfo.setList(logList);

        PageResponseBean page = new PageResponseBean<LogUser>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListForLogUserSms(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<LogUserSms> logList = logUserSmsMapper.selectList();
        PageInfo pageInfo = new PageInfo(logList);
        pageInfo.setList(logList);

        PageResponseBean page = new PageResponseBean<LogUserSms>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListForLogUserUpdate(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<LogUserUpdate> logList = logUserUpdateMapper.selectList();
        PageInfo pageInfo = new PageInfo(logList);
        pageInfo.setList(logList);

        PageResponseBean page = new PageResponseBean<LogUserUpdate>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListForEarn(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Earn> logList = earnMapper.selectList();
        PageInfo pageInfo = new PageInfo(logList);
        pageInfo.setList(logList);

        PageResponseBean page = new PageResponseBean<Earn>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }
}
