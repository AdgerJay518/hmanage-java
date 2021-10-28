package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.mapper.CmsSubjectCategoryMapper;
import com.manage.model.CmsSubjectCategory;
import com.manage.service.CmsSubjectCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by jonyon on 2021/10/28.
 */
@Service
public class CmsSubjectCategoryServiceImpl implements CmsSubjectCategoryService {
    @Autowired
    private CmsSubjectCategoryMapper subjectCategoryMapper;

    @Override
    public List<CmsSubjectCategory> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        CmsSubjectCategory cmsSubjectCategory = new CmsSubjectCategory();
        if(!StringUtils.isEmpty(subjectName)){
            cmsSubjectCategory.setName("%"+subjectName+"%");
        }
        if(recommendStatus!=null){
            cmsSubjectCategory.setShowStatus(recommendStatus);
        }
        return subjectCategoryMapper.selectBySubjectCategory(cmsSubjectCategory);
    }
}
