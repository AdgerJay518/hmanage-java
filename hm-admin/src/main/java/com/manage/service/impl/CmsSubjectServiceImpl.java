package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.mapper.CmsSubjectMapper;
import com.manage.model.CmsSubject;
import com.manage.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by jonyon on 2021/10/28.
 */
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper cmsSubjectMapper;

    @Override
    public List<CmsSubject> list(String keyword,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        CmsSubject cmsSubject = new CmsSubject();
        if(!StringUtils.isEmpty(keyword)){
            cmsSubject.setCategoryName("%"+keyword+"%");
        }
        return cmsSubjectMapper.selectBySubject(cmsSubject);
    }

    @Override
    public List<CmsSubject> listById(Integer pageSize, Integer pageNum, Long subjectId) {
        PageHelper.startPage(pageNum,pageSize);
        CmsSubject cmsSubject = new CmsSubject();
        cmsSubject.setCategoryId(subjectId);
        return cmsSubjectMapper.selectByCategoryId(cmsSubject);
    }
}
