package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.User;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.vo.UserVO;

public interface UserService {
    ResponseEntity<Integer> deleteByPrimaryKey(String id, String updateBy);

    ResponseEntity<Integer> insertSelective(User record);

    ResponseEntity<User> selectByPrimaryKey(String id);

    ResponseEntity<UserVO> selectInfoByPrimaryKey(String id);

    PageResponseBean selectList(Integer pageNum, Integer pageSize);

    PageResponseBean selectListBySearch(Integer pageNum, Integer pageSize, String search);

    ResponseEntity<Integer> selectCount();

    ResponseEntity<Integer> updateByPrimaryKeySelective(User record);

    ResponseEntity<Integer> updateByStatus(String id, Byte status, String updateBy);
}
