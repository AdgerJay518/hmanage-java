package com.manage.dao;

import com.manage.model.CmsSubject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jonyon on 2021/9/27.
 */
@Mapper
public interface HomeDao {
    /**
     * 获取推荐专题
     */
    List<CmsSubject> getRecommendSubjectList(
            @Param("offset") Integer offset,
            @Param("limit") Integer limit);

}
