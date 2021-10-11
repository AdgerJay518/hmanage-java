package com.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

/**
 * 生成计划单时，传入的参数
 * Created by jonyon on 2021/10/10.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderParam {
    @ApiModelProperty("被选中的计划sfID")
    private List<Long> planIds;

    @ApiModelProperty(value = "计划总卡路里")
    private BigDecimal totalCalorie;

    @ApiModelProperty(value = "计划总时长")
    private BigDecimal totalTime;
}
