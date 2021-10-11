package com.manage.domin;

import com.manage.model.PmsOrder;
import com.manage.model.PmsOrderItem;

import java.util.List;

/**
 * Created by jonyon on 2021/10/9.
 */
public class PmsOrderDetail extends PmsOrder {
    private List<PmsOrderItem> orderItemList;

    public List<PmsOrderItem> getOrderItemList() {
        return orderItemList;
    }
    public void setOrderItemList(List<PmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
