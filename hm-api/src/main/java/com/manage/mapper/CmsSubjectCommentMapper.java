package com.manage.mapper;

import com.manage.model.CmsSubjectComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmsSubjectCommentMapper {
    List<CmsSubjectComment> selectBySubjectId(CmsSubjectComment cmsSubjectComment);
}
