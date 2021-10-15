package com.manage.service;

import com.manage.domin.FmsFoodCategoryNode;
import com.manage.domin.FmsPortalFoodDetail;

import java.util.List;

/**
 *
 * @author jonyon
 * @date 2021/10/15
 */
public interface FmsPortalFoodService {
    List<FmsFoodCategoryNode> categoryTreeList();

    FmsPortalFoodDetail detail(Long id);
}
