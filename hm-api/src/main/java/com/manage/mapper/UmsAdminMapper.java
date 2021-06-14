package com.manage.mapper;

import com.manage.model.UmsAdmin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 吴政杰
 */
@Mapper
public interface UmsAdminMapper {
    public UmsAdmin getAdminByUsername(String username);
}
