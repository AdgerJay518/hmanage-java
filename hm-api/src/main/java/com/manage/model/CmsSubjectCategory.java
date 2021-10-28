package com.manage.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by jonyon on 2021/10/28.
 */
@Data
public class CmsSubjectCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String icon;

    private Integer subjectCount;

    private Integer showStatus;

    private Integer sort;
}
