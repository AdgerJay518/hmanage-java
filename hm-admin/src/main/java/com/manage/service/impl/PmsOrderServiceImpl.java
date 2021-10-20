package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.PmsOrderDao;
import com.manage.dto.PmsOrderDetail;
import com.manage.dto.PmsOrderQueryParam;
import com.manage.mapper.PmsOrderMapper;
import com.manage.mapper.PmsOrderOperateHistoryMapper;
import com.manage.model.PmsOrder;
import com.manage.model.PmsOrderOperateHistory;
import com.manage.service.PmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private PmsOrderMapper orderMapper;

    @Autowired
    private PmsOrderOperateHistoryMapper orderOperateHistoryMapper;

    @Override
    public List<PmsOrder> list(PmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.getList(queryParam);
    }

    @Override
    public PmsOrderDetail detail(Long id) {
        return orderDao.getDetail(id);
    }

    @Override
    public int updateNote(Long id, String note, Integer status) {
        PmsOrder order = new PmsOrder();
        order.setId(id);
        order.setNote(note);
        int count = orderMapper.updateByPrimaryKeySelective(order);
        PmsOrderOperateHistory history = new PmsOrderOperateHistory();
        history.setOrderId(id);
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(status);
        history.setNote("修改备注信息："+note);
        orderOperateHistoryMapper.insert(history);
        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        return orderMapper.deleteByIds(ids);
    }
}
