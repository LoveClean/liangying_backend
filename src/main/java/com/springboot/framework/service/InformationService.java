package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Information;
import com.springboot.framework.dao.entity.InformationInfo;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.vo.InformationVO;

public interface InformationService {
    ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy);

    ResponseEntity<Integer> insertSelective(Information record, InformationInfo record2);

    ResponseEntity<Information> selectByPrimaryKey(Integer id);

    ResponseEntity<InformationInfo> selectInfoByPrimaryKey(Integer id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    PageResponseBean selectListByTitle(String title, Integer pageNum, Integer pageSize);

    ResponseEntity<Integer> selectCount();

    ResponseEntity<Integer> updateByPrimaryKeySelective(Information record, InformationInfo record2);

    ResponseEntity<Integer> updateByStatus(Integer id, Byte status, String updateBy);
}
