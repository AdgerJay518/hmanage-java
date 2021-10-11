package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.dao.HomeDao;
import com.manage.domin.HomeContentResult;
import com.manage.mapper.CmsSubjectMapper;
import com.manage.mapper.HomeAdvertiseMapper;
import com.manage.model.CmsSubject;
import com.manage.model.HomeAdvertise;
import com.manage.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonyon on 2021/9/26.
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeAdvertiseMapper advertiseMapper;
    @Autowired
    private HomeDao homeDao;
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Override
    public HomeContentResult content() {
        HomeContentResult result = new HomeContentResult();
        //获取首页广告
        result.setAdvertiseList(getHomeAdvertiseList());
        //获取推荐专题
        result.setSubjectList(homeDao.getRecommendSubjectList(0,5));
        return result;
    }

    @Override
    public List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        CmsSubject cmsSubject = new CmsSubject();
        cmsSubject.setCategoryId(cateId);
        return subjectMapper.select(cmsSubject);
    }

    private List<HomeAdvertise> getHomeAdvertiseList(){
        return advertiseMapper.select(new HomeAdvertise());
    }
}
