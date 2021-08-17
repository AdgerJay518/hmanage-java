package com.manage.service;

import com.manage.dto.SmsSportQueryParam;
import com.manage.model.SmsSport;

import java.util.List;

/**
 * @author 吴政杰
 */
public interface SmsSportService {
    /**
     * 分页查询
     * @param sportQueryParam
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<SmsSport> list(SmsSportQueryParam sportQueryParam, Integer pageSize, Integer pageNum);
}
