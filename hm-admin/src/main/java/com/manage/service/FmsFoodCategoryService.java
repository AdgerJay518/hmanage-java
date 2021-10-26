package com.manage.service;

import com.manage.dto.FmsFoodCategoryWithChildren;
import com.manage.model.FmsFoodCategory;

import java.util.List;

/**
 * @author 吴政杰
 */
public interface FmsFoodCategoryService {
    List<FmsFoodCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    FmsFoodCategory getItem(Long id);

    int update(Long id, FmsFoodCategory foodCategoryParam);

    int updateNavStatus(Long id, Integer navStatus);

    int updateShowStatus(Long id, Integer showStatus);

    int create(FmsFoodCategory foodCategory);

    int delete(Long id);

    List<FmsFoodCategoryWithChildren> listWithChildren();
}
