package com.manage.service;

import com.manage.model.UmsMemberExtends;

public interface UmsMemberExtendsService {
    UmsMemberExtends getExtendsInfo(Long id);

    int update(UmsMemberExtends umsMemberExtends);

    String calculate(String height, String weight);
}
