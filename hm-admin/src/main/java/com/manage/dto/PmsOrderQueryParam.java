package com.manage.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jonyon on 2021/10/18.
 */
@Data
public class PmsOrderQueryParam {
    @ApiModelProperty(value = "计划编号")
    private String planSn;
    @ApiModelProperty(value = "状态：0->待执行；1->正在执行；2->已完成；3->已关闭；4->无效计划")
    private Integer status;
    @ApiModelProperty(value = "来源：0->PC；1->app")
    private Integer sourceType;
    @ApiModelProperty(value = "提交时间")
    private String createTime;
}
