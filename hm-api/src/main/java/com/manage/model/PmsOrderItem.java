package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by jonyon on 2021/10/9.
 */
@Data
public class PmsOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "计划id")
    private Long orderId;

    @ApiModelProperty(value = "计划编号")
    private String orderSn;

    private Long sfId;

    private String sfPic;

    private String sfName;

    private String sfSn;

    @ApiModelProperty(value = "卡路里")
    private BigDecimal sfCalorie;

    @ApiModelProperty(value = "数量")
    private Integer sfQuantity;

    @ApiModelProperty(value = "分类id")
    private Long sfCategoryId;

    private Integer giftIntegration;

    private Integer giftGrowth;

}
