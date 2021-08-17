package com.manage.dao;

import com.manage.dto.SmsSportCategoryWithChildren;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * @author jonyon
 * @date 2021/8/17
 */
@Mapper
public interface SmsSportCategoryDao {
    /**
     * 获取运动分类及其子分类
     * @return
     */
    List<SmsSportCategoryWithChildren> listWithChildren();
}
