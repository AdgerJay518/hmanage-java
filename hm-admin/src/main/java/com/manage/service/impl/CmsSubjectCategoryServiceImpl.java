package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.mapper.CmsSubjectCategoryMapper;
import com.manage.mapper.CmsSubjectMapper;
import com.manage.model.CmsSubject;
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

    @Autowired
    private CmsSubjectMapper cmsSubjectMapper;

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

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        CmsSubjectCategory cmsSubjectCategory = new CmsSubjectCategory();
        cmsSubjectCategory.setShowStatus(recommendStatus);
        return subjectCategoryMapper.updateByIds(ids,recommendStatus);
    }

    @Override
    public int updateSort(Long id, Integer sort) {
        CmsSubjectCategory cmsSubjectCategory = new CmsSubjectCategory();
        cmsSubjectCategory.setId(id);
        cmsSubjectCategory.setSort(sort);
        return subjectCategoryMapper.updateByPrimaryKeySelective(cmsSubjectCategory);
    }

    @Override
    public CmsSubjectCategory getItem(Long id) {
        return subjectCategoryMapper.selectById(id);
    }

    @Override
    public int create(CmsSubjectCategory cmsSubjectCategory) {
        cmsSubjectCategory.setSubjectCount(0);
        return subjectCategoryMapper.insert(cmsSubjectCategory);
    }

    @Override
    public int update(Long id, CmsSubjectCategory cmsSubjectCategory) {
        cmsSubjectCategory.setId(id);
        //专题更新时需要更新相应主题对应的专题名称
        CmsSubject cmsSubject = new CmsSubject();
        cmsSubject.setCategoryName(cmsSubjectCategory.getName());
        cmsSubject.setCategoryId(cmsSubjectCategory.getId());
        cmsSubjectMapper.update(cmsSubject);
        return subjectCategoryMapper.update(cmsSubjectCategory);
    }

    @Override
    public int deleteIds(List<Long> ids) {
        //专题背删除的同时，专题下的主题都会被删除
        cmsSubjectMapper.deleteByCateIds(ids);
        return subjectCategoryMapper.deleteByIds(ids);
    }

}
