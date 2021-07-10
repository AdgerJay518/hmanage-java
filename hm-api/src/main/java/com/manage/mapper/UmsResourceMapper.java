package com.manage.mapper;

import com.manage.model.UmsResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UmsResourceMapper {
    /**
     * 获取资源列表
     * @param resource
     * @return
     */
    List<UmsResource> selectByResource(UmsResource resource);

    /**
     * 更新资源列表
     * @param resource
     * @return
     */
    int updateByUmsResource(UmsResource resource);

    /**
     * 数据库插入新资源
     * @param umsResource
     * @return
     */
    int insert(UmsResource umsResource);

    /**
     * 根据id删除后台资源
     * @param id
     * @return
     */
    int deleteById(Long id);
}
