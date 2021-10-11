package com.manage.mapper;


import com.manage.model.CmsSubject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmsSubjectMapper {
    List<CmsSubject> select(CmsSubject cmsSubject);
}
