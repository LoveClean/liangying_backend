package com.springboot.framework.service;

import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Slideshow;
import com.springboot.framework.util.ResponseEntity;

import java.util.List;

public interface SlideshowService {
    ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy);

    ResponseEntity<Integer> deleteList(String[] ids, String updateBy);

    ResponseEntity<Integer> insertSelective(Slideshow record);

    ResponseEntity<Slideshow> selectByPrimaryKey(Integer id);

    ResponseEntity<List<Slideshow>> selectList();

//    ResponseEntity<Slideshow> selectList(Integer pageNum, Integer pageSize);

    ResponseEntity<Integer> selectCount();

    ResponseEntity<Integer> updateByPrimaryKeySelective(Slideshow record);
}
