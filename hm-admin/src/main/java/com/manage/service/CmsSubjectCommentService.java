package com.manage.service;

import com.manage.model.CmsSubjectComment;

import java.util.List;

public interface CmsSubjectCommentService {
    List<CmsSubjectComment> listById(Integer pageSize, Integer pageNum, Long subjectId);
}
