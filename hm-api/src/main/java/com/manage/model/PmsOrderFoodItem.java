package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PmsOrderFoodItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "计划id")
    private Long orderId;

    @ApiModelProperty(value = "计划编号")
    private String orderSn;

    private Long foodId;

    private String foodPic;

    private String foodName;

    private String foodSn;

    @ApiModelProperty(value = "卡路里")
    private BigDecimal foodCalorie;

    @ApiModelProperty(value = "数量")
    private Integer foodQuantity;

    @ApiModelProperty(value = "分类id")
    private Long foodCategoryId;

    private Integer giftIntegration;

    private Integer giftGrowth;
}
