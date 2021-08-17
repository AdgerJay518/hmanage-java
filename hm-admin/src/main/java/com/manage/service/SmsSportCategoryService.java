package com.manage.service;

import com.manage.dto.SmsSportCategoryWithChildren;
import com.manage.model.SmsSportCategory;

import java.util.List;

/**
 * @author 吴政杰
 */
public interface SmsSportCategoryService {
    /**
     * 分页获取商品分类
     */
    List<SmsSportCategory> getList(Long parentId, Integer pageSize, Integer pageNum);
    /**
     * 批量修改导航状态
     */
    int updateNavStatus(Long id, Integer navStatus);

    /**
     * 批量修改显示状态
     */
    int updateShowStatus(Long id, Integer showStatus);

    /**
     * 删除运动分类
     */
    int delete(Long id);

    /**
     * 根据id获取运动分类
     * @param id
     * @return
     */
    SmsSportCategory getItem(Long id);

    /**
     * 添加运动分类
     * @param sportCategory
     * @return
     */
    int create(SmsSportCategory sportCategory);

    /**
     * 修改运动分类
     * @param id
     * @param sportCategoryParam
     * @return
     */
    int update(Long id, SmsSportCategory sportCategoryParam);

    /**
     * 查询所有运动的分类及其子分类
     * @return
     */
    List<SmsSportCategoryWithChildren> listWithChildren();
}
