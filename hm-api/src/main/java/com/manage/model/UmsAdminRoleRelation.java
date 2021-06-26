package com.manage.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by jonyon on 2021/6/26.
 */
@Data
public class UmsAdminRoleRelation implements Serializable {
    private Long id;

    private Long adminId;

    private Long roleId;
}
