package com.springboot.framework.controller;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "日志操作接口", produces = "application/json")
@RestController
@RequestMapping("/log/")
public class LogController extends BaseController {
    @Autowired
    private LogService logService;

    @ApiOperation(value = "管理员操作记录", notes = "管理员操作记录")
    @GetMapping(value = "selectListForLogAdmin")
    public PageResponseBean selectListForLogAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return logService.selectListForLogAdmin(pageNum, pageSize);
    }

    @ApiOperation(value = "用户登录记录", notes = "用户登录记录")
    @GetMapping(value = "selectListForLogUserLogin")
    public PageResponseBean selectListForLogUserLogin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return logService.selectListForLogUserLogin(pageNum, pageSize);
    }

    @ApiOperation(value = "用户操作记录", notes = "用户操作记录")
    @GetMapping(value = "selectListForLogUser")
    public PageResponseBean selectListForLogUser(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return logService.selectListForLogUser(pageNum, pageSize);
    }

    @ApiOperation(value = "短信操作记录", notes = "短信操作记录")
    @GetMapping(value = "selectListForLogUserSms")
    public PageResponseBean selectListForLogUserSms(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return logService.selectListForLogUserSms(pageNum, pageSize);
    }

    @ApiOperation(value = "用户更新记录", notes = "用户更新记录")
    @GetMapping(value = "selectListForLogUserUpdate")
    public PageResponseBean selectListForLogUserUpdate(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return logService.selectListForLogUserUpdate(pageNum, pageSize);
    }
}
