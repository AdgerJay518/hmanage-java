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
}
