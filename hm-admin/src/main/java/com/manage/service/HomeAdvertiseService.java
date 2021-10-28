package com.manage.service;

import com.manage.model.HomeAdvertise;

import java.util.List;

public interface HomeAdvertiseService {
    List<HomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum);

    HomeAdvertise getItem(Long id);

    int updateStatus(Long id, Integer status);

    int create(HomeAdvertise advertise);

    int delete(List<Long> ids);

    int update(Long id, HomeAdvertise advertise);
}
