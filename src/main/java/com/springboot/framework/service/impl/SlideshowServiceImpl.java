package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Slideshow;
import com.springboot.framework.dao.mapper.SlideshowMapper;
import com.springboot.framework.service.SlideshowService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SlideshowServiceImpl implements SlideshowService {
    @Resource
    private SlideshowMapper slideshowMapper;

    @Override
    public ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy) {
        return ResponseEntityUtil.success(slideshowMapper.deleteByPrimaryKey(id, updateBy));
    }

    @Override
    public ResponseEntity<Integer> deleteList(String[] ids, String updateBy) {
        return ResponseEntityUtil.success(slideshowMapper.deleteList(ids, updateBy));
    }

    @Override
    public ResponseEntity<Integer> insertSelective(Slideshow record) {
        if (slideshowMapper.insertSelective(record) != 1) {
            return ResponseEntityUtil.fail("新增轮播图失败");
        }
        return ResponseEntityUtil.success();
    }

    @Override
    public ResponseEntity<Slideshow> selectByPrimaryKey(Integer id) {
        return ResponseEntityUtil.success(slideshowMapper.selectByPrimaryKey(id));
    }

    @Override
    public ResponseEntity<List<Slideshow>> selectList() {
        List<Slideshow> list = slideshowMapper.selectList();
        if (list.size() == 0) {
            return ResponseEntityUtil.fail("没有任何数据!");
        }
        return ResponseEntityUtil.success(list);
    }

//    @Override
//    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
//        PageHelper.startPage(pageNum, pageSize);
//        List<Slideshow> loanList = slideshowMapper.selectList();
//        PageInfo pageInfo = new PageInfo(loanList);
//        pageInfo.setList(loanList);
//
//        PageResponseBean page = new PageResponseBean<Slideshow>(pageInfo);
//        page.setCode(0);
//        page.setHttpStatus(200);
//        return page;
//    }

    @Override
    public ResponseEntity<Integer> selectCount() {
        return ResponseEntityUtil.success(slideshowMapper.selectCount());
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(Slideshow record) {
        if (slideshowMapper.updateByPrimaryKeySelective(record) != 1) {
            return ResponseEntityUtil.fail("轮播图更新失败");
        }
        return ResponseEntityUtil.success();
    }
}
