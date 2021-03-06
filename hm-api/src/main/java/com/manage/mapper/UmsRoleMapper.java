package com.manage.mapper;

import com.manage.model.UmsRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UmsRoleMapper {
    List<UmsRole> selectByRole(UmsRole role);

    /**
     * 根据角色名模糊查询
     * @param name
     * @return
     */
    List<UmsRole> getByLikeName(String name);

    /**
     * 通过id更新用户信息
     * @param umsRole
     * @return
     */
    int updateByUmsRole(UmsRole umsRole);

    /**
     * 创建角色
     * @param umsRole
     * @return
     */
    int create(UmsRole umsRole);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);
}
