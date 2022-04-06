package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jonyon on 2021/10/7.
 */
@Data
public class PlanItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long sfId;

    private Long memberId;

    @ApiModelProperty(value = "判断是运动还是食品")
    private Integer sf;

    @ApiModelProperty(value = "数量")
    private Integer quantity;

    @ApiModelProperty(value = "添加到计划的卡路里")
    private BigDecimal calorie;

    @ApiModelProperty(value = "主图")
    private String sfPic;

    @ApiModelProperty(value = "名称")
    private String sfName;

    @ApiModelProperty(value = "条码")
    private String sfSn;

    @ApiModelProperty(value = "用户昵称")
    private String memberNickname;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    private Date modifyDate;

    @ApiModelProperty(value = "是否删除")
    private Integer deleteStatus;

    @ApiModelProperty(value = "分类")
    private Long sfCategoryId;
}
