package com.manage.mapper;

import com.manage.model.UmsAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 吴政杰
 */
@Mapper
public interface UmsAdminMapper {
    /**
     * 根据用户名找到用户信息
     * @param username
     * @return
     */
    List<UmsAdmin> getAdminByUsername(String username);

    /**
     * 根据id找到用户信息
     * @param id
     * @return
     */
    UmsAdmin selectByPrimaryKey(Long id);

    /**
     * 更新用户信息
     * @param admin
     * @return
     */
    int updateByPrimaryKeySelective(UmsAdmin admin);
}
