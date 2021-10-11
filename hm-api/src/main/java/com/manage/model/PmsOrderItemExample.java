package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 *
 * @author jonyon
 * @date 2021/10/11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsOrderItemExample {
    @ApiModelProperty("所有计划id")
    private List<Long> orderIds;
}
