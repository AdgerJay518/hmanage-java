package com.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class manageParam {
    @ApiModelProperty("消耗的卡路里")
    private BigDecimal totalCalorie;

    @ApiModelProperty("摄取的卡路里")
    private BigDecimal ingestionCalorie;
}
