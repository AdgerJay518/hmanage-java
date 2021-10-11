package com.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * Created by jonyon on 2021/10/8.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PlanItemParam {
    @NotEmpty
    @ApiModelProperty(value = "用户id",required = true)
    private Long id;
}
