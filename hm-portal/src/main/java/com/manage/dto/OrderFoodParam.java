package com.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderFoodParam {
    @ApiModelProperty("被选中的ID")
    private List<Long> planIds;

    @ApiModelProperty(value = "饮食摄取的卡路里")
    private BigDecimal ingestionCalorie;

    @ApiModelProperty(value = "总克数")
    private BigDecimal totalK;
}
