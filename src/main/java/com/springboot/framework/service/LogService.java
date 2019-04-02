package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.LogAdmin;
import com.springboot.framework.util.ResponseEntity;

public interface LogService {
    ResponseEntity<Integer> insertSelective(LogAdmin record);

    PageResponseBean selectListForLogAdmin(Integer pageNum, Integer pageSize);

    PageResponseBean selectListForLogUserLogin(Integer pageNum, Integer pageSize);

    PageResponseBean selectListForLogUser(Integer pageNum, Integer pageSize);

    PageResponseBean selectListForLogUserSms(Integer pageNum, Integer pageSize);

    PageResponseBean selectListForLogUserUpdate(Integer pageNum, Integer pageSize);
}
