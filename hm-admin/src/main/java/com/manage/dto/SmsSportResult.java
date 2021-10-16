package com.manage.dto;

import com.manage.model.SmsSport;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jonyon on 2021/10/16.
 */
@Data
public class SmsSportResult extends SmsSport {
    @ApiModelProperty("运动所选分类的父id")
    private Long cateParentId;
}
