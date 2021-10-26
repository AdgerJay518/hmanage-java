package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.FmsFoodDao;
import com.manage.dto.FmsFoodQueryParam;
import com.manage.dto.FmsFoodResult;
import com.manage.mapper.FmsFoodMapper;
import com.manage.model.FmsFood;
import com.manage.service.FmsFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author jonyon
 * @date 2021/10/25
 */
@Service
public class FmsFoodServiceImpl implements FmsFoodService {

    @Autowired
    private FmsFoodMapper fmsFoodMapper;

    @Autowired
    private FmsFoodDao fmsFoodDao;

    @Override
    public List<FmsFood> list(FmsFoodQueryParam foodQueryParam, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FmsFood fmsFood = new FmsFood();
        if (foodQueryParam.getKeyword()!=null){
            fmsFood.setName("%"+foodQueryParam.getKeyword()+"%");
        }
        if (foodQueryParam.getFoodSn()!=null){
            fmsFood.setFoodSn("%"+foodQueryParam.getFoodSn()+"%");
        }
        if (foodQueryParam.getFoodCategoryId()!=null){
            fmsFood.setFoodCategoryId(foodQueryParam.getFoodCategoryId());
        }
        return fmsFoodMapper.selectByFood(fmsFood);
    }

    @Override
    public FmsFoodResult getUpdateInfo(Long id) {
        return fmsFoodDao.getUpdateInfo(id);
    }

    @Override
    public int update(Long id, FmsFood fmsFood) {
        int count;
        fmsFood.setId(id);
        fmsFoodMapper.updateByPrimaryKeySelective(fmsFood);
        count = 1;
        return count;
    }

    @Override
    public int create(FmsFood fmsFood) {
        int count;
        fmsFood.setId(null);
        fmsFoodMapper.insertSelective(fmsFood);
        count = 1;
        return count;
    }

    @Override
    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        return fmsFoodMapper.deleteByIds(ids);
    }

    @Override
    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return fmsFoodMapper.updateStatusByIds(recommendStatus,ids);
    }
}
