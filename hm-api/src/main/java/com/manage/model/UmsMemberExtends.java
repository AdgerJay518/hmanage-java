package com.manage.model;

import lombok.Data;

/**
 * Created by jonyon on 2022/3/5.
 */
@Data
public class UmsMemberExtends extends UmsMember{
    private Long id;
    private Long memberId;
    private String weight;
    private String height;
}
