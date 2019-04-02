package com.springboot.framework.controller;

import com.springboot.framework.controller.request.InformationInsert;
import com.springboot.framework.controller.request.InformationUpdateByPrimaryKey;
import com.springboot.framework.controller.request.UpdateByStatus;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Information;
import com.springboot.framework.dao.entity.InformationInfo;
import com.springboot.framework.service.InformationService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.vo.InformationVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(description = "资讯管理操作接口", produces = "application/json")
@RestController
@RequestMapping("/information/")
public class InformationController extends BaseController {
    @Autowired
    private InformationService informationService;

    @ApiOperation(value = "删除资讯", notes = "删除资讯信息")
    @DeleteMapping(value = "deleteByPrimaryKey")
    public ResponseEntity<Integer> deleteByPrimaryKey(@RequestParam Integer id, HttpServletRequest request) {
        return informationService.deleteByPrimaryKey(id, super.getSessionUser(request).getAccount());
    }

    @ApiOperation(value = "新增资讯", notes = "新增资讯信息")
    @PostMapping(value = "insertSelective")
    public ResponseEntity<Integer> insertSelective(@RequestBody InformationInsert bean, HttpServletRequest request) {
        Information record = new Information(bean.getTitle(), bean.getCover(), bean.getCategory(), bean.getIntroduction(), super.getSessionUser(request).getAccount());
        InformationInfo record2 = new InformationInfo(null, bean.getPicture(), bean.getContent());
        return informationService.insertSelective(record, record2);
    }

    @ApiOperation(value = "查看资讯", notes = "查看资讯信息")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<Information> selectByPrimaryKey(@RequestParam Integer id) {
        return informationService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查看资讯详情信息", notes = "查看资讯详情信息")
    @GetMapping(value = "selectInfoByPrimaryKey")
    public ResponseEntity<InformationInfo> selectInfoByPrimaryKey(@RequestParam Integer id) {
        return informationService.selectInfoByPrimaryKey(id);
    }

    @ApiOperation(value = "查看资讯列表", notes = "查看资讯信息列表")
    @GetMapping(value = "selectList")
    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return informationService.selectList(pageNum, pageSize);
    }

    @ApiOperation(value = "根据标题查看资讯列表", notes = "根据标题查看资讯信息列表")
    @GetMapping(value = "selectListByTitle")
    public PageResponseBean selectListByTitle(@RequestParam String title, @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        return informationService.selectListByTitle(title, pageNum, pageSize);
    }

    @ApiOperation(value = "更新资讯", notes = "更新资讯信息")
    @PutMapping(value = "updateByPrimaryKeySelective")
    public ResponseEntity<Integer> updateByPrimaryKeySelective(@RequestBody InformationUpdateByPrimaryKey bean, HttpServletRequest request) {
        Information record = new Information(bean.getTitle(), bean.getCover(), bean.getCategory(), bean.getIntroduction(), null);
        record.setId(bean.getId());
        record.setUpdateBy(super.getSessionUser(request).getAccount());
        InformationInfo record2 = new InformationInfo(bean.getId(), bean.getPicture(), bean.getContent());
        return informationService.updateByPrimaryKeySelective(record, record2);
    }

    @ApiOperation(value = "更新资讯状态", notes = "更新资讯状态")
    @PutMapping(value = "updateByStatus")
    public ResponseEntity<Integer> updateByStatus(@RequestBody UpdateByStatus bean, HttpServletRequest request) {
        return informationService.updateByStatus(bean.getId(), bean.getStatus(), super.getSessionUser(request).getAccount());
    }

}
