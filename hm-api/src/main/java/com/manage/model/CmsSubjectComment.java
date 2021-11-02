package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jonyon on 2021/11/2.
 */
@Data
public class CmsSubjectComment implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "主题id")
    private Long subjectId;

    @ApiModelProperty(value = "用户昵称")
    private String memberNickName;

    @ApiModelProperty(value = "用户头像")
    private String memberIcon;

    private String content;

    private Date createTime;

    @ApiModelProperty(value = "显示状态：0->不显示；1->显示")
    private Integer showStatus;
}
