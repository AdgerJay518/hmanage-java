package com.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.manage.mapper.HomeAdvertiseMapper;
import com.manage.model.HomeAdvertise;
import com.manage.service.HomeAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jonyon on 2021/10/26.
 */
@Service
public class HomeAdvertiseServiceImpl implements HomeAdvertiseService {
    @Autowired
    private HomeAdvertiseMapper advertiseMapper;

    @Override
    public List<HomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        HomeAdvertise homeAdvertise = new HomeAdvertise();
        if (!StringUtils.isEmpty(name)){
            homeAdvertise.setName("%" + name + "%");
        }
        if (type!=null){
            homeAdvertise.setType(type);
        }
        if (!StringUtils.isEmpty(endTime)){
            String startStr = endTime + " 00:00:00";
            String endStr = endTime + " 23:59:59";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = null;
            try {
                start = sdf.parse(startStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Date end = null;
            try {
                end = sdf.parse(endStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (start != null && end != null){
                homeAdvertise.setStartTime(start);
                homeAdvertise.setEndTime(end);
            }
        }
        return advertiseMapper.select(homeAdvertise);
    }

    @Override
    public HomeAdvertise getItem(Long id) {
        return advertiseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        HomeAdvertise homeAdvertise = new HomeAdvertise();
        homeAdvertise.setId(id);
        homeAdvertise.setStatus(status);
        return advertiseMapper.updateByPrimaryKeySelective(homeAdvertise);
    }

    @Override
    public int create(HomeAdvertise advertise) {
        advertise.setClickCount(0);
        return advertiseMapper.insert(advertise);
    }

    @Override
    public int delete(List<Long> ids) {
        return advertiseMapper.deleteByIds(ids);
    }

    @Override
    public int update(Long id, HomeAdvertise advertise) {
        advertise.setId(id);
        return advertiseMapper.updateByPrimaryKeySelective(advertise);
    }
}
