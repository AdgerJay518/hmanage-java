package com.manage.dto;

import com.manage.model.PmsOrder;
import com.manage.model.PmsOrderItem;
import com.manage.model.PmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by jonyon on 2021/10/18.
 */
public class PmsOrderDetail extends PmsOrder {
    @Getter
    @Setter
    @ApiModelProperty("订单商品列表")
    private List<PmsOrderItem> orderItemList;
    @Getter
    @Setter
    @ApiModelProperty("订单操作记录列表")
    private List<PmsOrderOperateHistory> historyList;
}
