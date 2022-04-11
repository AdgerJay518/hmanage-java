package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PlanItemFood implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long foodId;

    private Long memberId;

    @ApiModelProperty(value = "数量")
    private Integer quantity;

    @ApiModelProperty(value = "添加到计划的卡路里")
    private BigDecimal calorie;

    @ApiModelProperty(value = "主图")
    private String foodPic;

    @ApiModelProperty(value = "名称")
    private String foodName;

    @ApiModelProperty(value = "编号")
    private String foodSn;

    @ApiModelProperty(value = "用户昵称")
    private String memberNickname;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    private Date modifyDate;

    @ApiModelProperty(value = "是否删除")
    private Integer deleteStatus;

    @ApiModelProperty(value = "分类")
    private Long foodCategoryId;
}
