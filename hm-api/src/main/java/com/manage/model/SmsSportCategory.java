package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author jonyon
 * @date 2021/8/12
 */
@Data
public class SmsSportCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    @ApiModelProperty(value = "上级分类的编号：0表示一级分类")
    private Long parentId;

    private String name;

    @ApiModelProperty(value = "分类级别：0->1级；1->2级")
    private Integer level;

    @ApiModelProperty(value = "是否显示在导航栏：0->不显示；1->显示")
    private Integer navStatus;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Integer showStatus;

    private Integer sort;

    @ApiModelProperty(value = "图标")
    private String icon;

    private String keywords;

    @ApiModelProperty(value = "描述")
    private String description;
}
