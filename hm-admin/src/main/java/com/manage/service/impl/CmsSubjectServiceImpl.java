package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.mapper.CmsSubjectCategoryMapper;
import com.manage.mapper.CmsSubjectMapper;
import com.manage.model.CmsSubject;
import com.manage.model.CmsSubjectCategory;
import com.manage.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by jonyon on 2021/10/28.
 */
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper cmsSubjectMapper;

    @Autowired
    private CmsSubjectCategoryMapper cmsSubjectCategoryMapper;

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

    @Override
    public CmsSubject getItem(Long id) {
        return cmsSubjectMapper.selectById(id);
    }

    @Override
    public int create(CmsSubject cmsSubject) {
        CmsSubject subject = new CmsSubject();
        subject.setCategoryId(cmsSubject.getCategoryId());
        subject.setTitle(cmsSubject.getTitle());
        subject.setPic(cmsSubject.getPic());
        subject.setRecommendStatus(cmsSubject.getRecommendStatus());
        subject.setCreateTime(new Date());
        subject.setCollectCount(0);
        subject.setReadCount(0);
        subject.setCommentCount(0);
        subject.setDescription(cmsSubject.getDescription());
        subject.setShowStatus(1);
        subject.setCategoryName(getCategoryNameByCategoryId(cmsSubject.getCategoryId()));
        Long id = cmsSubject.getCategoryId();
        int count = getSubjectCountByCategoryId(id);
        count+=1;
        CmsSubjectCategory cmsSubjectCategory = new CmsSubjectCategory();
        cmsSubjectCategory.setId(id);
        cmsSubjectCategory.setSubjectCount(count);
        cmsSubjectCategoryMapper.update(cmsSubjectCategory);
        return cmsSubjectMapper.insert(subject);
    }

    @Override
    public int deleteId(long id) {
        Long categoryId = getCategoryId(id);
        int count = getSubjectCountByCategoryId(categoryId);
        count-=1;
        CmsSubjectCategory cmsSubjectCategory = new CmsSubjectCategory();
        cmsSubjectCategory.setId(categoryId);
        cmsSubjectCategory.setSubjectCount(count);
        cmsSubjectCategoryMapper.update(cmsSubjectCategory);
        return cmsSubjectMapper.delete(id);
    }

    @Override
    public int update(Long id, CmsSubject cmsSubject) {
        CmsSubject subject = new CmsSubject();
        subject.setId(id);
        return cmsSubjectMapper.updateById(cmsSubject);
    }

    private String getCategoryNameByCategoryId(Long id){
        return cmsSubjectCategoryMapper.getName(id);
    }

    private int getSubjectCountByCategoryId(Long id){
        return cmsSubjectCategoryMapper.getSubjectCount(id);
    }

    private Long getCategoryId(Long id){
        return cmsSubjectMapper.getCategoryId(id);
    }
}
