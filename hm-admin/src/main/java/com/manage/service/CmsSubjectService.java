package com.manage.service;

import com.manage.model.CmsSubject;

import java.util.List;

public interface CmsSubjectService {
    List<CmsSubject> list(String keyword,Integer pageSize, Integer pageNum);

    List<CmsSubject> listById(Integer pageSize, Integer pageNum, Long subjectId);

    CmsSubject getItem(Long id);

    int create(CmsSubject cmsSubject);

    int deleteId(long id);

    int update(Long id, CmsSubject cmsSubject);
}
