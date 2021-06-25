package com.manage.mapper;

import com.manage.model.UmsResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UmsResourceMapper {
    /**
     * 获取资源列表
     * @param resource
     * @return
     */
    List<UmsResource> selectByResource(UmsResource resource);
}