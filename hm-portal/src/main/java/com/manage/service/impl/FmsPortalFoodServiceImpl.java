package com.manage.service.impl;

import com.manage.domin.FmsFoodCategoryNode;
import com.manage.domin.FmsPortalFoodDetail;
import com.manage.domin.PmsPortalSportDetail;
import com.manage.domin.SmsSportCategoryNode;
import com.manage.mapper.FmsFoodCategoryMapper;
import com.manage.mapper.FmsFoodMapper;
import com.manage.model.FmsFood;
import com.manage.model.FmsFoodCategory;
import com.manage.model.SmsSport;
import com.manage.model.SmsSportCategory;
import com.manage.service.FmsPortalFoodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jonyon on 2021/10/15.
 */
@Service
public class FmsPortalFoodServiceImpl implements FmsPortalFoodService {

    @Autowired
    private FmsFoodCategoryMapper foodCategoryMapper;

    @Autowired
    private FmsFoodMapper foodMapper;

    @Override
    public List<FmsFoodCategoryNode> categoryTreeList() {
        FmsFoodCategory fmsFoodCategory = new FmsFoodCategory();
        List<FmsFoodCategory> allList=foodCategoryMapper.selectByCategory(fmsFoodCategory);
        List<FmsFoodCategoryNode> result = allList.stream()
                .filter(item -> item.getParentId().equals(0L))
                .map(item -> covert(item, allList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public FmsPortalFoodDetail detail(Long id) {
        FmsPortalFoodDetail result = new FmsPortalFoodDetail();
        FmsFood food=foodMapper.selectByPrimaryKey(id);
        result.setFood(food);
        return result;
    }

    /**
     * 初始对象转化为节点对象
     */
    private FmsFoodCategoryNode covert(FmsFoodCategory item, List<FmsFoodCategory> allList) {
        FmsFoodCategoryNode node = new FmsFoodCategoryNode();
        BeanUtils.copyProperties(item, node);
        List<FmsFoodCategoryNode> children = allList.stream()
                .filter(subItem -> subItem.getParentId().equals(item.getId()))
                .map(subItem -> covert(subItem, allList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
