package com.manage.service;

import com.manage.model.UmsMember;

import java.util.List;

public interface UmsMemberService {
    List<UmsMember> list(String keyword, Integer pageSize, Integer pageNum);
}
