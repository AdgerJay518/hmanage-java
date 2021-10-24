package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.mapper.FmsFoodCategoryMapper;
import com.manage.mapper.FmsFoodMapper;
import com.manage.model.FmsFood;
import com.manage.model.FmsFoodCategory;
import com.manage.model.SmsSportCategory;
import com.manage.service.FmsFoodCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author jonyon
 * @date 2021/10/24
 */
@Service
public class FmsFoodCategoryServiceImpl implements FmsFoodCategoryService {
    @Autowired
    private FmsFoodCategoryMapper foodCategoryMapper;

    @Autowired
    private FmsFoodMapper fmsFoodMapper;

    @Override
    public List<FmsFoodCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return foodCategoryMapper.selectByParentId(parentId);
    }

    @Override
    public FmsFoodCategory getItem(Long id) {
        return foodCategoryMapper.selectById(id);
    }

    @Override
    public int update(Long id, FmsFoodCategory foodCategoryParam) {
        foodCategoryParam.setId(id);
        setCategoryLevel(foodCategoryParam);
        FmsFood fmsFood = new FmsFood();
        fmsFood.setFoodCategoryName(foodCategoryParam.getName());
        fmsFood.setFoodCategoryId(foodCategoryParam.getId());
        fmsFoodMapper.updateFood(fmsFood);
        return foodCategoryMapper.update(foodCategoryParam);
    }

    @Override
    public int updateNavStatus(Long id, Integer navStatus) {
        FmsFoodCategory foodCategory = new FmsFoodCategory();
        foodCategory.setId(id);
        foodCategory.setNavStatus(navStatus);
        return foodCategoryMapper.updateByFoodCategory(foodCategory);
    }

    @Override
    public int updateShowStatus(Long id, Integer showStatus) {
        FmsFoodCategory foodCategory = new FmsFoodCategory();
        foodCategory.setId(id);
        foodCategory.setShowStatus(showStatus);
        return foodCategoryMapper.updateByFoodCategory(foodCategory);
    }

    @Override
    public int create(FmsFoodCategory foodCategory) {
        setCategoryLevel(foodCategory);
        return foodCategoryMapper.insert(foodCategory);
    }

    @Override
    public int delete(Long id) {
        return foodCategoryMapper.deleteById(id);
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void setCategoryLevel(FmsFoodCategory FoodCategory) {
        //没有父分类时为一级分类
        if (FoodCategory.getParentId() == 0) {
            FoodCategory.setLevel(0);
        } else {
            //有父分类时选择根据父分类level设置
            FmsFoodCategory parentCategory = foodCategoryMapper.selectById(FoodCategory.getParentId());
            if (parentCategory != null) {
                FoodCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                FoodCategory.setLevel(0);
            }
        }
    }
}
