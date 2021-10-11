package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jonyon on 2021/10/9.
 */
@Data
public class PmsOrderOperateHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "计划id")
    private Long orderId;

    @ApiModelProperty(value = "操作人：用户；系统；后台管理员")
    private String operateMan;

    @ApiModelProperty(value = "操作时间")
    private Date createTime;

    @ApiModelProperty(value = "状态：0->待执行；1->正在执行；2->已完成；3->已关闭；4->无效计划")
    private Integer orderStatus;

    @ApiModelProperty(value = "备注")
    private String note;
}
