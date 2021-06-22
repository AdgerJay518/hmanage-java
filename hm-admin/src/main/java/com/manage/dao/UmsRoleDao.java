package com.manage.dao;

import com.manage.model.UmsMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台角色管理自定义Dao
 * @author 吴政杰
 */
@Mapper
public interface UmsRoleDao {
    /**
     * 根据ID获取对应菜单
     */
    List<UmsMenu> getMenuList(@Param("adminId") Long adminId);
}
