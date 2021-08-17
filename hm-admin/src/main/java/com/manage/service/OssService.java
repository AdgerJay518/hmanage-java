package com.manage.service;

import com.manage.dto.OssCallbackResult;
import com.manage.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss对象存储管理Service
 * @author 吴政杰
 */
public interface OssService {
    /**
     * Oss上传策略生成
     */
    OssPolicyResult policy();
    /**
     * Oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
