package com.manage.service;

import com.manage.domin.HomeContentResult;
import com.manage.model.CmsSubject;

import java.util.List;

public interface HomeService {
    /**
     * 获取首页内容
     */
    HomeContentResult content();

    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);
}
