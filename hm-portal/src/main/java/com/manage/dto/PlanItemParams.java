package com.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by jonyon on 2021/10/12.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PlanItemParams {
    @ApiModelProperty("计划ID")
    private List<Long> planIds;
}
