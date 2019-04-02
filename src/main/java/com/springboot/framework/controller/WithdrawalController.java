package com.springboot.framework.controller;

import com.springboot.framework.controller.request.UpdateByStatus;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Withdrawal;
import com.springboot.framework.service.WithdrawalService;
import com.springboot.framework.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(description = "提现流水操作接口", produces = "application/json")
@RestController
@RequestMapping("/withdrawal/")
public class WithdrawalController extends BaseController {
    @Autowired
    private WithdrawalService withdrawalService;

    @ApiOperation(value = "查看提现流水记录", notes = "查看提现流水记录")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<Withdrawal> selectByPrimaryKey(@RequestParam Integer id) {
        return withdrawalService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查看提现流水列表", notes = "根据用户id提现流水记录")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return withdrawalService.selectList(pageNum, pageSize);
    }

    @ApiOperation(value = "根据用户id查看提现流水列表", notes = "根据用户id提现流水记录")
    @GetMapping(value = "selectListByUserId")
    public PageResponseBean selectListByUserId(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String userId) {
        return withdrawalService.selectListByUserId(pageNum, pageSize, userId);
    }

    @ApiOperation(value = "更新提现流水记录", notes = "更新提现流水记录")
    @PutMapping(value = "updateByStatus")
    public ResponseEntity<Integer> updateByStatus(@RequestBody UpdateByStatus bean, HttpServletRequest request) {
        return withdrawalService.updateByStatus(bean.getId(), bean.getStatus(), super.getSessionUser(request).getAccount());
    }
}
