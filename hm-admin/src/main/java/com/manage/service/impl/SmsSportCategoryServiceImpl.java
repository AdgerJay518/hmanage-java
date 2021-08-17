package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.SmsSportCategoryDao;
import com.manage.dto.SmsSportCategoryWithChildren;
import com.manage.mapper.SmsSportCategoryMapper;
import com.manage.mapper.SmsSportMapper;
import com.manage.model.SmsSport;
import com.manage.model.SmsSportCategory;
import com.manage.service.SmsSportCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类模块操作
 * Created by jonyon on 2021/8/12.
 */
@Service
public class SmsSportCategoryServiceImpl implements SmsSportCategoryService {
    @Autowired
    private SmsSportCategoryMapper sportCategory;
    @Autowired
    private SmsSportMapper smsSportMapper;
    @Autowired
    private SmsSportCategoryDao smsSportCategoryDao;

    @Override
    public List<SmsSportCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return sportCategory.selectByParentId(parentId);
    }

    @Override
    public int updateNavStatus(Long id, Integer navStatus) {
        SmsSportCategory smsSportCategory = new SmsSportCategory();
        smsSportCategory.setId(id);
        smsSportCategory.setNavStatus(navStatus);
        return sportCategory.updateBySmsSportCategory(smsSportCategory);
    }

    @Override
    public int updateShowStatus(Long id, Integer showStatus) {
        SmsSportCategory smsSportCategory = new SmsSportCategory();
        smsSportCategory.setId(id);
        smsSportCategory.setShowStatus(showStatus);
        return sportCategory.updateBySmsSportCategory(smsSportCategory);
    }

    @Override
    public int delete(Long id) {
        return sportCategory.deleteById(id);
    }

    @Override
    public SmsSportCategory getItem(Long id) {
        return sportCategory.selectById(id);
    }

    @Override
    public int create(SmsSportCategory sportCategoryParam) {
        setCategoryLevel(sportCategoryParam);
        return sportCategory.insert(sportCategoryParam);
    }

    @Override
    public int update(Long id, SmsSportCategory sportCategoryParam) {
        sportCategoryParam.setId(id);
        setCategoryLevel(sportCategoryParam);
        //更新运动分类时要更新运动列表中的名称
        SmsSport smsSport = new SmsSport();
        smsSport.setSportCategoryName(sportCategoryParam.getName());
        smsSport.setSportCategoryId(sportCategoryParam.getId());
        smsSportMapper.updateSport(smsSport);
        return sportCategory.update(sportCategoryParam);
    }

    @Override
    public List<SmsSportCategoryWithChildren> listWithChildren() {
        return smsSportCategoryDao.listWithChildren();
    }

    /**
     * 根据分类的parentId设置分类的level
     */
    private void setCategoryLevel(SmsSportCategory SportCategory) {
        //没有父分类时为一级分类
        if (SportCategory.getParentId() == 0) {
            SportCategory.setLevel(0);
        } else {
            //有父分类时选择根据父分类level设置
            SmsSportCategory parentCategory = sportCategory.selectById(SportCategory.getParentId());
            if (parentCategory != null) {
                SportCategory.setLevel(parentCategory.getLevel() + 1);
            } else {
                SportCategory.setLevel(0);
            }
        }
    }

}
