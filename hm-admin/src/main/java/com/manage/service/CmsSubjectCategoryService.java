package com.manage.service;

import com.manage.model.CmsSubject;
import com.manage.model.CmsSubjectCategory;

import java.util.List;

public interface CmsSubjectCategoryService {
    List<CmsSubjectCategory> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum);

    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    int updateSort(Long id, Integer sort);

    CmsSubjectCategory getItem(Long id);

    int create(CmsSubjectCategory cmsSubjectCategory);

    int update(Long id, CmsSubjectCategory cmsSubjectCategory);

    int deleteIds(List<Long> ids);
}
