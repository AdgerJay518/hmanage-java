package com.manage.service;

/**
 * 常用Redis操作
 * @author 吴政杰
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
}
