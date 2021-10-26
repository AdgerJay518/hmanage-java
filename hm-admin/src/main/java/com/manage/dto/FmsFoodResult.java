package com.manage.dto;

import com.manage.model.FmsFood;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by jonyon on 2021/10/26.
 */
@Data
public class FmsFoodResult extends FmsFood {
    @ApiModelProperty("食品所选分类的父id")
    private Long cateParentId;
}
