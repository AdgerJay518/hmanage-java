package com.manage.mapper;

import com.manage.model.CmsSubject;
import com.manage.model.CmsSubjectCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jonyon on 2021/10/28.
 */
@Mapper
public interface CmsSubjectCategoryMapper {
    List<CmsSubjectCategory> selectBySubjectCategory(CmsSubjectCategory cmsSubjectCategory);


    int updateByIds(List<Long> ids, Integer showStatus);

    int updateByPrimaryKeySelective(CmsSubjectCategory cmsSubjectCategory);

    CmsSubjectCategory selectById(Long id);

    int insert(CmsSubjectCategory cmsSubjectCategory);

    int update(CmsSubjectCategory cmsSubjectCategory);

    int deleteByIds(List<Long> ids);
}
