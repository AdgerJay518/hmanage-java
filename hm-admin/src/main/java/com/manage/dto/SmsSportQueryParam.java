package com.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 运动查询参数
 * @author jonyon
 * @date 2021/8/17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SmsSportQueryParam {
    @ApiModelProperty("运动名称关键字")
    private String keyword;
    @ApiModelProperty("运动号")
    private String sportSn;
    @ApiModelProperty("运动分类编号")
    private Long sportCategoryId;
}
