package com.manage.mapper;

import com.manage.model.UmsResourceCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 吴政杰
 */
@Mapper
public interface UmsResourceCategoryMapper {
    /**
     * 查询所有后台资源分类列表
     * @return
     */
    List<UmsResourceCategory> selectAll();

    /**
     * 更新后台资源分类列表
     * @param umsResourceCategory
     * @return
     */
    int updateByUmsResourceCategory(UmsResourceCategory umsResourceCategory);

    /**
     * 插入台资源分类
     * @param umsResourceCategory
     * @return
     */
    int insert(UmsResourceCategory umsResourceCategory);

    /**
     * 删除后台资源
     * @param id
     * @return
     */
    int delete(Long id);
}
