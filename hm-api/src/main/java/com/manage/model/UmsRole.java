package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jonyon
 * @date 2021/6/22
 */
@Data
public class UmsRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "描述")
    private String description;
    @ApiModelProperty(value = "后台用户数量")
    private Integer adminCount;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "启用状态：0->禁用；1->启用")
    private Integer status;
    @ApiModelProperty(value = "排序")
    private Integer sort;
}
