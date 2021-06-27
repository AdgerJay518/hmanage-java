package com.manage.mapper;

import com.manage.model.UmsResourceCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 吴政杰
 */
@Mapper
public interface UmsResourceCategoryMapper {
    List<UmsResourceCategory> selectAll();
}
