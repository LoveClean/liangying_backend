package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.Information;
import com.springboot.framework.dao.entity.InformationInfo;
import com.springboot.framework.dao.mapper.InformationInfoMapper;
import com.springboot.framework.dao.mapper.InformationMapper;
import com.springboot.framework.service.InformationService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import com.springboot.framework.vo.InformationVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Resource
    private InformationMapper informationMapper;
    @Resource
    private InformationInfoMapper informationInfoMapper;

    @Override
    public ResponseEntity<Integer> deleteByPrimaryKey(Integer id, String updateBy) {
        return ResponseEntityUtil.success(informationMapper.deleteByPrimaryKey(id, updateBy));
    }

    @Override

    public ResponseEntity<Integer> insertSelective(Information record, InformationInfo record2) {
        if (informationMapper.insertSelective(record) != 1) {
            return ResponseEntityUtil.fail("资讯添加失败");
        }
        if (informationInfoMapper.insertSelective(record2) != 1) {
            return ResponseEntityUtil.fail("资讯详情添加失败");
        }
        return ResponseEntityUtil.success();
    }

    @Override
    public ResponseEntity<Information> selectByPrimaryKey(Integer id) {
        return ResponseEntityUtil.success(informationMapper.selectByPrimaryKey(id));
    }

//    @Override
//    public ResponseEntity<InformationVO> selectInfoByPrimaryKey(Integer id) {
//        Information record = informationMapper.selectByPrimaryKey(id);
//        InformationInfo record2 = informationInfoMapper.selectByPrimaryKey(id);
//        InformationVO recordVO = new InformationVO(record, record2);
//        return ResponseEntityUtil.success(recordVO);
//    }

    @Override
    public ResponseEntity<InformationInfo> selectInfoByPrimaryKey(Integer id) {
        return ResponseEntityUtil.success(informationInfoMapper.selectByPrimaryKey(id));
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Information> loanList = informationMapper.selectList();
        PageInfo pageInfo = new PageInfo(loanList);
        pageInfo.setList(loanList);

        PageResponseBean page = new PageResponseBean<Information>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public PageResponseBean selectListByTitle(String title, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Information> loanList = informationMapper.selectListByTitle(title);
        PageInfo pageInfo = new PageInfo(loanList);
        pageInfo.setList(loanList);

        PageResponseBean page = new PageResponseBean<Information>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }

    @Override
    public ResponseEntity<Integer> selectCount() {
        return ResponseEntityUtil.success(informationMapper.selectCount());
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(Information record, InformationInfo record2) {
        if (informationMapper.updateByPrimaryKeySelective(record) != 1) {
            return ResponseEntityUtil.fail("资讯更新失败");
        }
        if (informationInfoMapper.updateByPrimaryKeySelective(record2) != 1) {
            return ResponseEntityUtil.fail("资讯详情更新失败");
        }
        return ResponseEntityUtil.success();
    }

    @Override
    public ResponseEntity<Integer> updateByStatus(Integer id, Byte status, String updateBy) {
        Information record = new Information();
        record.setId(id);
        record.setStatus(status);
        record.setUpdateBy(updateBy);
        return ResponseEntityUtil.success(informationMapper.updateByPrimaryKeySelective(record));
    }
}
