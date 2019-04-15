package com.springboot.framework.controller;

import com.springboot.framework.service.*;
import com.springboot.framework.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(description = "公共接口", produces = "application/json")
@RestController
@RequestMapping("/public/")
public class PublicController {
    @Resource
    private AdminService adminService;
    @Resource
    private InformationService informationService;
    @Resource
    private LoanService loanService;
    @Resource
    private UserService userService;
    @Resource
    private WithdrawalService withdrawalService;
    @Resource
    private SlideshowService slideshowService;

    @ApiOperation(value = "查看管理员总数", notes = "查看管理员总数")
    @GetMapping(value = "selectCountForAdmin")
    public ResponseEntity<Integer> selectCountForAdmin() {
        return adminService.selectCount();
    }

    @ApiOperation(value = "查看资讯总数", notes = "查看资讯总数")
    @GetMapping(value = "selectCountForInformation")
    public ResponseEntity<Integer> selectCountForInformation() {
        return informationService.selectCount();
    }

    @ApiOperation(value = "查看贷款记录总数", notes = "查看贷款记录总数")
    @GetMapping(value = "selectCountForLoan")
    public ResponseEntity<Integer> selectCountForLoan() {
        return loanService.selectCount();
    }

    @ApiOperation(value = "查看用户总数", notes = "查看用户总数")
    @GetMapping(value = "selectCountForUser")
    public ResponseEntity<Integer> selectCountForUser() {
        return userService.selectCount();
    }

    @ApiOperation(value = "查看提现流水总数", notes = "查看提现流水总数")
    @GetMapping(value = "selectCountForWithdrawal")
    public ResponseEntity<Integer> selectCountForWithdrawal() {
        return withdrawalService.selectCount();
    }

    @ApiOperation(value = "查看轮播图总数", notes = "查看轮播图总数")
    @GetMapping(value = "selectCountForSlideshow")
    public ResponseEntity<Integer> selectCountForSlideshow() {
        return slideshowService.selectCount();
    }
}
