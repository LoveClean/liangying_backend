package com.springboot.framework.controller;

import com.springboot.framework.controller.request.SlideshowInsert;
import com.springboot.framework.controller.request.SlideshowUpdateByPrimaryKey;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Slideshow;
import com.springboot.framework.service.SlideshowService;
import com.springboot.framework.util.ResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(description = "轮播图管理操作接口", produces = "application/json")
@RestController
@RequestMapping("/slideshow/")
public class SlideshowController extends BaseController {
    @Autowired
    private SlideshowService slideshowService;

    @ApiOperation(value = "删除轮播图", notes = "删除轮播图信息")
    @DeleteMapping(value = "deleteByPrimaryKey")
    public ResponseEntity<Integer> deleteByPrimaryKey(@RequestParam Integer id, HttpServletRequest request) {
        return slideshowService.deleteByPrimaryKey(id, super.getSessionUser(request).getAccount());
    }

    @ApiOperation(value = "批量删除轮播图", notes = "批量删除轮播图")
    @DeleteMapping(value = "deleteList")
    public ResponseEntity<Integer> deleteList(@RequestParam String[] ids, HttpServletRequest request) {
        return slideshowService.deleteList(ids, super.getSessionUser(request).getAccount());
    }

    @ApiOperation(value = "新增轮播图", notes = "新增轮播图信息")
    @PostMapping(value = "insertSelective")
    public ResponseEntity<Integer> insertSelective(@RequestBody SlideshowInsert bean, HttpServletRequest request) {
        Slideshow record = new Slideshow(bean.getInformationId(), bean.getName(), bean.getPicture(), super.getSessionUser(request).getAccount());
        return slideshowService.insertSelective(record);
    }

    @ApiOperation(value = "查看轮播图", notes = "查看轮播图信息")
    @GetMapping(value = "selectByPrimaryKey")
    public ResponseEntity<Slideshow> selectByPrimaryKey(@RequestParam Integer id) {
        return slideshowService.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "查看轮播图列表", notes = "查看轮播图列表")
    @GetMapping(value = "selectList")
    public ResponseEntity<List<Slideshow>> getAll() {
        return slideshowService.selectList();
    }

//    @ApiOperation(value = "查看轮播图列表", notes = "查看轮播图信息列表")
//    @GetMapping(value = "selectList")
//    public PageResponseBean selectList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
//        return slideshowService.selectList(pageNum, pageSize);
//    }

    @ApiOperation(value = "更新轮播图", notes = "更新轮播图信息")
    @PutMapping(value = "updateByPrimaryKeySelective")
    public ResponseEntity<Integer> updateByPrimaryKeySelective(@RequestBody SlideshowUpdateByPrimaryKey bean, HttpServletRequest request) {
        Slideshow record = new Slideshow(bean.getInformationId(), bean.getName(), bean.getPicture(), null);
        record.setId(bean.getId());
        record.setUpdateBy(super.getSessionUser(request).getAccount());
        return slideshowService.updateByPrimaryKeySelective(record);
    }
}
