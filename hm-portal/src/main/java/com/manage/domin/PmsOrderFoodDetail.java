package com.manage.domin;

import com.manage.model.PmsOrderFood;
import com.manage.model.PmsOrderFoodItem;

import java.util.List;

public class PmsOrderFoodDetail extends PmsOrderFood {
    private List<PmsOrderFoodItem> orderFoodItemList;

    public List<PmsOrderFoodItem> getOrderFoodItemList() {
        return orderFoodItemList;
    }

    public void setOrderFoodItemList(List<PmsOrderFoodItem> orderFoodItemList) {
        this.orderFoodItemList = orderFoodItemList;
    }

    public PmsOrderFoodDetail(List<PmsOrderFoodItem> orderFoodItemList) {
        this.orderFoodItemList = orderFoodItemList;
    }

    public PmsOrderFoodDetail() {
    }
}
