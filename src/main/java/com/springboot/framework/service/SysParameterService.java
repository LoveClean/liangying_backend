package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.util.ResponseEntity;

public interface SysParameterService {
    ResponseEntity<Integer> insertSelective(String key, String value, String note, String createBy);

    ResponseEntity<Integer> updateByPrimaryKeySelective(Integer id, String key, String value, String note, String updateBy);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);
}
