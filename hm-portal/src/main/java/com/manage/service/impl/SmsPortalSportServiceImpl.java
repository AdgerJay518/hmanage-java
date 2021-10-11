package com.manage.service.impl;

import com.manage.domin.PmsPortalSportDetail;
import com.manage.domin.SmsSportCategoryNode;
import com.manage.mapper.SmsSportCategoryMapper;
import com.manage.mapper.SmsSportMapper;
import com.manage.model.SmsSport;
import com.manage.model.SmsSportCategory;
import com.manage.service.SmsPortalSportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jonyon on 2021/9/8.
 */
@Service
public class SmsPortalSportServiceImpl implements SmsPortalSportService {
    @Autowired
    private SmsSportCategoryMapper sportCategoryMapper;
    @Autowired
    private SmsSportMapper smsSportMapper;

    @Override
    public List<SmsSportCategoryNode> categoryTreeList() {
        SmsSportCategory smsSportCategory = new SmsSportCategory();
        List<SmsSportCategory> allList=sportCategoryMapper.selectByCategory(smsSportCategory);
        List<SmsSportCategoryNode> result = allList.stream()
                .filter(item -> item.getParentId().equals(0L))
                .map(item -> covert(item, allList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public PmsPortalSportDetail detail(Long id) {
        PmsPortalSportDetail result = new PmsPortalSportDetail();
        SmsSport sport=smsSportMapper.selectByPrimaryKey(id);
        result.setSport(sport);
        return result;
    }

    /**
     * 初始对象转化为节点对象
     */
    private SmsSportCategoryNode covert(SmsSportCategory item, List<SmsSportCategory> allList) {
        SmsSportCategoryNode node = new SmsSportCategoryNode();
        BeanUtils.copyProperties(item, node);
        List<SmsSportCategoryNode> children = allList.stream()
                .filter(subItem -> subItem.getParentId().equals(item.getId()))
                .map(subItem -> covert(subItem, allList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
