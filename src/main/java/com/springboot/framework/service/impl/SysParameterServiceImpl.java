package com.springboot.framework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.framework.controller.response.PageResponseBean;
import com.springboot.framework.dao.entity.SysParameter;
import com.springboot.framework.dao.mapper.SysParameterMapper;
import com.springboot.framework.service.SysParameterService;
import com.springboot.framework.util.ResponseEntity;
import com.springboot.framework.util.ResponseEntityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysParameterServiceImpl implements SysParameterService {
    @Resource
    private SysParameterMapper sysParameterMapper;

    @Override
    public ResponseEntity<Integer> insertSelective(String key, String value, String note, String createBy) {
        SysParameter sysParameter = new SysParameter(key, value, note, createBy);
        return ResponseEntityUtil.success(sysParameterMapper.insertSelective(sysParameter));
    }

    @Override
    public ResponseEntity<Integer> updateByPrimaryKeySelective(Integer id, String key, String value, String note, String updateBy) {
        SysParameter sysParameter = new SysParameter();
        sysParameter.setId(id);
        sysParameter.setKey(key);
        sysParameter.setValue(value);
        sysParameter.setNote(note);
        sysParameter.setUpdateBy(updateBy);
        return ResponseEntityUtil.success(sysParameterMapper.updateByPrimaryKeySelective(sysParameter));
    }

    @Override
    public PageResponseBean selectList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysParameter> sysParameterList = sysParameterMapper.selectList();
        PageInfo pageInfo = new PageInfo(sysParameterList);
        pageInfo.setList(sysParameterList);

        PageResponseBean page = new PageResponseBean<SysParameter>(pageInfo);
        page.setCode(0);
        page.setHttpStatus(200);
        return page;
    }
}
