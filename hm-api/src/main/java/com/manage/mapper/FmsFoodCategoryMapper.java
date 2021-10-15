package com.manage.mapper;


import com.manage.model.FmsFood;
import com.manage.model.FmsFoodCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FmsFoodCategoryMapper {
    List<FmsFoodCategory> selectByCategory(FmsFoodCategory fmsFoodCategory);

}
