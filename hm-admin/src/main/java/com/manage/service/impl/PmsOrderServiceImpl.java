package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.PmsOrderDao;
import com.manage.dto.PmsOrderDetail;
import com.manage.dto.PmsOrderQueryParam;
import com.manage.model.PmsOrder;
import com.manage.service.PmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author jonyon
 * @date 2021/10/18
 */
@Service
public class PmsOrderServiceImpl implements PmsOrderService {

    @Autowired
    private PmsOrderDao orderDao;

    @Override
    public List<PmsOrder> list(PmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.getList(queryParam);
    }

    @Override
    public PmsOrderDetail detail(Long id) {
        return orderDao.getDetail(id);
    }
}
