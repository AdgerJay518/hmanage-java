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
public class UmsMenu implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    @ApiModelProperty(value = "父级ID")
    private Long parentId;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "菜单名称")
    private String title;
    @ApiModelProperty(value = "菜单级数")
    private Integer level;
    @ApiModelProperty(value = "菜单排序")
    private Integer sort;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "图标")
    private String icon;
    @ApiModelProperty(value = "是否隐藏")
    private  Integer hidden;
}
