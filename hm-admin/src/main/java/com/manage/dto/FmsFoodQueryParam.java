package com.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author jonyon
 * @date 2021/10/25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FmsFoodQueryParam {
    @ApiModelProperty("食品名称关键字")
    private String keyword;
    @ApiModelProperty("食品号")
    private String foodSn;
    @ApiModelProperty("食品分类编号")
    private Long foodCategoryId;
}
