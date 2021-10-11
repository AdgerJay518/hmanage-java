package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jonyon on 2021/9/27.
 */
@Data
public class CmsSubject implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long categoryId;

    private String title;

    @ApiModelProperty(value = "专题主图")
    private String pic;

    private Integer recommendStatus;

    private Date createTime;

    private Integer collectCount;

    private Integer readCount;

    private Integer commentCount;

    @ApiModelProperty(value = "画册图片用逗号分割")
    private String albumPics;

    private String description;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Integer showStatus;

    @ApiModelProperty(value = "转发数")
    private Integer forwardCount;

    @ApiModelProperty(value = "专题分类名称")
    private String categoryName;

    private String content;

}
