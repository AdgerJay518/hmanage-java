package com.manage.service;

import com.manage.dto.FmsFoodQueryParam;
import com.manage.dto.FmsFoodResult;
import com.manage.model.FmsFood;

import java.util.List;

/**
 * @author 吴政杰
 */
public interface FmsFoodService {
    List<FmsFood> list(FmsFoodQueryParam foodQueryParam, Integer pageSize, Integer pageNum);

    FmsFoodResult getUpdateInfo(Long id);

    int update(Long id, FmsFood fmsFood);

    int create(FmsFood fmsFood);

    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);
}
