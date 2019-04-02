package com.springboot.framework.controller;

import com.springboot.framework.controller.request.UpdateByStatus;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Loan;
import com.springboot.framework.service.LoanService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.vo.LoanVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(description = "贷款管理操作接口", produces = "application/json")
@RestController
@RequestMapping("/loan/")
public class LoanController extends BaseController {
    @Autowired
    private LoanService loanService;

    @ApiOperation(value = "删除贷款信息", notes = "删除贷款信息")
    @DeleteMapping(value = "deleteByPrimaryKey")
    public ResponseEntity<Integer> deleteByPrimaryKey(@RequestParam Integer id, HttpServletRequest request) {
        return loanService.deleteByPrimaryKey(id, super.getSessionUser(request).getAccount());
    }

    @ApiOperation(value = "查看贷款信息", notes = "查看贷款信息")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<Loan> selectByPrimaryKey(@RequestParam Integer id) {
        return loanService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查看贷款详情信息", notes = "查看贷款详情信息")
    @GetMapping(value = "selectInfoByPrimaryKey")
    public ResponseEntity<LoanVO> selectInfoByPrimaryKey(@RequestParam Integer id) {
        return loanService.selectInfoByPrimaryKey(id);
    }

    @ApiOperation(value = "查看贷款信息列表", notes = "查看贷款信息列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return loanService.selectList(pageNum, pageSize);
    }

    @ApiOperation(value = "搜索贷款信息列表", notes = "搜索贷款信息列表")
    @GetMapping(value = "selectListBySearch")
    public PageResponseBean selectListBySearch(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String search) {
        return loanService.selectListBySearch(pageNum, pageSize, search);
    }

    @ApiOperation(value = "更新贷款状态", notes = "更新贷款状态")
    @PutMapping(value = "updateByStatus")
    public ResponseEntity<Integer> updateByStatus(@RequestBody UpdateByStatus bean, HttpServletRequest request) {
        return loanService.updateByStatus(bean.getId(), bean.getStatus(), super.getSessionUser(request).getAccount());
    }
}
