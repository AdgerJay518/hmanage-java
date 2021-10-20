package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jonyon on 2021/10/9.
 */
@Data
public class PmsOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "计划id")
    private Long id;

    private Long memberId;

    @ApiModelProperty(value = "计划编号")
    private String planSn;

    @ApiModelProperty(value = "提交时间")
    private Date createTime;

    @ApiModelProperty(value = "用户帐号")
    private String memberUsername;

    @ApiModelProperty(value = "计划总卡路里")
    private BigDecimal totalCalorie;

    @ApiModelProperty(value = "计划总时长")
    private BigDecimal totalTime;

    @ApiModelProperty(value = "来源：0->PC；1->app")
    private Integer sourceType;

    @ApiModelProperty(value = "状态：0->待执行；1->正在执行；2->已完成；3->已关闭；4->无效计划")
    private Integer status;

    @ApiModelProperty(value = "自动确认时间（天）")
    private Integer autoConfirmDay;

    @ApiModelProperty(value = "可以获得的积分")
    private Integer integration;

    @ApiModelProperty(value = "可以活动的成长值")
    private Integer growth;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "确认收货状态：0->未确认；1->已确认")
    private Integer confirmStatus;

    @ApiModelProperty(value = "删除状态：0->未删除；1->已删除")
    private Integer deleteStatus;

    @ApiModelProperty(value = "执行时间")
    private Date startTime;

    @ApiModelProperty(value = "确认完成时间")
    private Date confirmTime;
}
