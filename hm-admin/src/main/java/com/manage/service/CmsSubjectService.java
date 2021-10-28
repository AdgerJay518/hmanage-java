package com.manage.service;

import com.manage.model.CmsSubject;

import java.util.List;

public interface CmsSubjectService {
    List<CmsSubject> list(String keyword,Integer pageSize, Integer pageNum);
}
