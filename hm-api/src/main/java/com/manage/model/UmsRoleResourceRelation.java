package com.manage.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by jonyon on 2021/7/3.
 */
@Data
public class UmsRoleResourceRelation implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "资源ID")
    private Long resourceId;
}
