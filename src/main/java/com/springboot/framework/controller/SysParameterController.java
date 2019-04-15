package com.springboot.framework.controller;

import com.springboot.framework.controller.request.SysParameterInsert;
import com.springboot.framework.controller.request.SysParameterUpdate;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.service.SysParameterService;
import com.springboot.framework.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(description = "系统参数操作接口", produces = "application/json")
@RestController
@RequestMapping("/sysParameter/")
public class SysParameterController extends BaseController {
    @Resource
    private SysParameterService sysParameterService;

    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping(value = "insertSelective")
    public ResponseEntity<Integer> insertSelective(@RequestBody SysParameterInsert bean, HttpServletRequest request) {
        return sysParameterService.insertSelective(bean.getKey(), bean.getValue(), bean.getNote(), super.getSessionUser(request).getAccount());
    }

    @ApiOperation(value = "更新", notes = "更新")
    @PutMapping(value = "updateByPrimaryKeySelective")
    public ResponseEntity<Integer> updateByPrimaryKeySelective(@RequestBody SysParameterUpdate bean, HttpServletRequest request) {
        return sysParameterService.updateByPrimaryKeySelective(bean.getId(), bean.getKey(), bean.getValue(), bean.getNote(), super.getSessionUser(request).getAccount());
    }

    @ApiOperation(value = "查看列表", notes = "查看列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return sysParameterService.selectList(pageNum, pageSize);
    }
}
