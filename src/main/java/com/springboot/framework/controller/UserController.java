package com.springboot.framework.controller;

import com.springboot.framework.controller.request.UpdateByStatus;
import com.springboot.framework.controller.request.UserUpdateByStatus;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.User;
import com.springboot.framework.service.UserService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import com.springboot.framework.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(description = "用户管理操作接口", produces = "application/json")
@RestController
@RequestMapping("/user/")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @DeleteMapping(value = "deleteByPrimaryKey")
    public ResponseEntity<Integer> deleteByPrimaryKey(@RequestParam String id, HttpServletRequest request) {
        return userService.deleteByPrimaryKey(id, super.getSessionUser(request).getAccount());
    }

//    @ApiOperation(value = "新增用户", notes = "新增用户")
//    @PostMapping(value = "insertSelective")
//    public ResponseEntity<Integer> insertSelective(@RequestBody UserInsert bean, HttpServletRequest request) {
//        User record = new User(bean.getAccount(), bean.getPassword(), bean.getPhone(), bean.getName(), super.getSessionUser(request).getAccount());
//        return userService.insertSelective(record);
//    }

    @ApiOperation(value = "查看用户", notes = "查看用户")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<User> selectByPrimaryKey(@RequestParam String id) {
        return userService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查看用户详情", notes = "查看用户详情")
    @GetMapping(value = "selectInfoByPrimaryKey")
    public ResponseEntity<UserVO> selectInfoByPrimaryKey(@RequestParam String id) {
        return userService.selectInfoByPrimaryKey(id);
    }

    @ApiOperation(value = "查看用户列表", notes = "查看用户列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return userService.selectList(pageNum, pageSize);
    }

    @ApiOperation(value = "搜索用户列表", notes = "查看用户列表")
    @GetMapping(value = "selectListBySearch")
    public PageResponseBean selectListBySearch(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String search) {
        return userService.selectListBySearch(pageNum, pageSize, search);
    }

//    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
//    @PutMapping(value = "updateByPrimaryKeySelective")
//    public ResponseEntity<Integer> updateByPrimaryKeySelective(@RequestBody UserUpdateByPrimaryKey bean, HttpServletRequest request) {
//        User record = new User(null, bean.getPassword(), bean.getPhone(), bean.getName(), null);
//        record.setId(bean.getId());
//        record.setUpdateBy(super.getSessionUser(request).getAccount());
//        record.setStatus(bean.getStatus());
//        return userService.updateByPrimaryKeySelective(record);
//    }

    @ApiOperation(value = "更新用户状态", notes = "更新用户状态")
    @PutMapping(value = "updateByStatus")
    public ResponseEntity<Integer> updateByStatus(@RequestBody UserUpdateByStatus bean, HttpServletRequest request) {
        return userService.updateByStatus(bean.getId(), bean.getStatus(), super.getSessionUser(request).getAccount());
    }
}
