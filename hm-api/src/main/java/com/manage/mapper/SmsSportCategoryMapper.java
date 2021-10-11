package com.manage.mapper;

import com.manage.model.SmsSportCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 吴政杰
 */
@Mapper
public interface SmsSportCategoryMapper {
    List<SmsSportCategory> selectByParentId(Long parentId);
    int updateBySmsSportCategory(SmsSportCategory smsSportCategory);
    int deleteById(Long id);
    SmsSportCategory selectById(Long id);
    int insert(SmsSportCategory sportCategoryParam);
    int update(SmsSportCategory smsSportCategory);
    List<SmsSportCategory> selectByCategory(SmsSportCategory smsSportCategory);
}
