package com.manage.service;

import com.manage.domin.PmsPortalSportDetail;
import com.manage.domin.SmsSportCategoryNode;

import java.util.List;

public interface SmsPortalSportService {
    List<SmsSportCategoryNode> categoryTreeList();

    PmsPortalSportDetail detail(Long id);
}
