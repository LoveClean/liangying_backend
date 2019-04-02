package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.User;
import com.springboot.framework.dao.entity.UserInfo;
import com.springboot.framework.dao.mapper.UserInfoMapper;
import com.springboot.framework.dao.mapper.UserMapper;
import com.springboot.framework.service.UserService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import com.springboot.framework.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public ResponseEntity<Integer> deleteByPrimaryKey(String id, String updateBy) {
        return ResponseEntityUtil.success(userMapper.deleteByPrimaryKey(id, updateBy));
    }

    @Override
    public ResponseEntity<Integer> insertSelective(User record) {
        return null;
    }

    @Override
    public ResponseEntity<User> selectByPrimaryKey(String id) {
        return ResponseEntityUtil.success(userMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResponseEntity<UserVO> selectInfoByPrimaryKey(String id) {
        User record = userMapper.selectByPrimaryKey(id);
        UserInfo record2 = userInfoMapper.selectByPrimaryKey(id);
        UserVO recordVO = new UserVO(record, record2);
        return ResponseEntityUtil.success(recordVO);
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectList();
        PageInfo pageInfo = new PageInfo(userList);
        pageInfo.setList(userList);

        PageResponseBean page = new PageResponseBean<User>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListBySearch(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectListBySearch(search);
        PageInfo pageInfo = new PageInfo(userList);
        pageInfo.setList(userList);

        PageResponseBean page = new PageResponseBean<User>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public ResponseEntity<Integer> selectCount() {
        return ResponseEntityUtil.success(userMapper.selectCount());
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(User record) {
        User validResponse = userMapper.selectByPhone(record.getPhone());
        if (validResponse != null && validResponse.getId() != record.getId()) {
            return ResponseEntityUtil.fail("此手机号已被注册");
        }
        return ResponseEntityUtil.success(userMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public ResponseEntity<Integer> updateByStatus(String id, Byte status, String updateBy) {
        User record = new User();
        record.setId(id);
        record.setStatus(status);
        record.setUpdateBy(updateBy);
        return ResponseEntityUtil.success(userMapper.updateByPrimaryKeySelective(record));
    }
}
