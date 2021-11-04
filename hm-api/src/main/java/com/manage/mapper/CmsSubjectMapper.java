package com.manage.mapper;


import com.manage.model.CmsSubject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmsSubjectMapper {
    List<CmsSubject> select(CmsSubject cmsSubject);

    List<CmsSubject> selectBySubject(CmsSubject cmsSubject);

    List<CmsSubject> selectByCategoryId(CmsSubject cmsSubject);

    void update(CmsSubject cmsSubject);

    void deleteByCateIds(List<Long> ids);

    CmsSubject selectById(Long id);

    int insert(CmsSubject subject);

    int delete(long id);

    int updateById(CmsSubject cmsSubject);

    Long getCategoryId(Long id);
}
