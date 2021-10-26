package com.manage.service;

import com.manage.model.HomeAdvertise;

import java.util.List;

public interface HomeAdvertiseService {
    List<HomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum);
}
