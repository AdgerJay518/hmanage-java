package com.manage.component;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 动态权限相关业务类
 * @author 吴政杰
 */
@Component
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
