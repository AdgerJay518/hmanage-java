package com.manage.dao;

import com.manage.dto.FmsFoodCategoryWithChildren;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FmsFoodCategoryDao {
    List<FmsFoodCategoryWithChildren> listWithChildren();
}
