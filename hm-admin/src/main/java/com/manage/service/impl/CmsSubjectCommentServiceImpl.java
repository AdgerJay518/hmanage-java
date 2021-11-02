package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.mapper.CmsSubjectCommentMapper;
import com.manage.model.CmsSubjectComment;
import com.manage.service.CmsSubjectCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonyon on 2021/11/2.
 */
@Service
public class CmsSubjectCommentServiceImpl implements CmsSubjectCommentService {
    @Autowired
    private CmsSubjectCommentMapper commentMapper;

    @Override
    public List<CmsSubjectComment> listById(Integer pageSize, Integer pageNum, Long subjectId) {
        PageHelper.startPage(pageNum,pageSize);
        CmsSubjectComment cmsSubjectComment = new CmsSubjectComment();
        cmsSubjectComment.setSubjectId(subjectId);
        return commentMapper.selectBySubjectId(cmsSubjectComment);
    }
}
