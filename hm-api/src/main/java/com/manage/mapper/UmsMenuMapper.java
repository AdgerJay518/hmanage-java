package com.manage.mapper;

import com.manage.model.UmsMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 吴政杰
 */
@Mapper
public interface UmsMenuMapper {
    List<UmsMenu> selectByParentId(Long parentId);
    List<UmsMenu> selectByUmsMenu(UmsMenu umsMenu);
    int updateByUmsMenu(UmsMenu umsMenu);
    UmsMenu selectById(Long id);
    int insert(UmsMenu umsMenu);
    int delete(Long id);
}
