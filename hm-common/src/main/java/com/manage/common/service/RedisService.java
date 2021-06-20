package com.manage.common.service;

import java.util.List;

/**
 * Created by jonyon on 2021/6/14.
 */
public interface RedisService {
    /**
     * 保存属性,包括过期时间
     */
    void set(String key, Object value, long time);
    /**
     * 保存属性
     */
    void set(String key, Object value);

    /**
     * 获取属性
     */
    Object get(String key);
    /**
     * 删除属性
     */
    Boolean del(String key);

    /**
     * 批量删除属性
     */
    Long del(List<String> keys);
}

