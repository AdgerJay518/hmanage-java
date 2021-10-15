package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by jonyon on 2021/10/14.
 */
@Data
public class FmsFood implements Serializable {
    private Long id;

    @ApiModelProperty(value = "食品分类id")
    private Long foodCategoryId;

    private String name;

    private String pic;

    @ApiModelProperty(value = "食品号")
    private String foodSn;

    @ApiModelProperty(value = "推荐状态；0->不推荐；1->推荐")
    private Integer recommandStatus;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "食品分类名称")
    private String foodCategoryName;

    @ApiModelProperty(value = "卡路里")
    private Integer calorie;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "单位")
    private String unit;

    @ApiModelProperty(value = "关键字")
    private String keywords;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "画册图片，连产品图片限制为5张，以逗号分割")
    private String albumPics;

    @ApiModelProperty(value = "详情标题")
    private String detailTitle;

    @ApiModelProperty(value = "详情描述")
    private String detailDesc;

    @ApiModelProperty(value = "产品详情网页内容")
    private String detailHtml;

    @ApiModelProperty(value = "移动端网页详情")
    private String detailMobileHtml;
}
