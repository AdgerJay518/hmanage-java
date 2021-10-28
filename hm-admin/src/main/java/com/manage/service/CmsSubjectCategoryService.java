package com.manage.service;

import com.manage.model.CmsSubjectCategory;

import java.util.List;

public interface CmsSubjectCategoryService {
    List<CmsSubjectCategory> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
