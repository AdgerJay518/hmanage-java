package com.manage.mapper;

import com.manage.model.HomeAdvertise;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by jonyon on 2021/9/26.
 */

@Mapper
public interface HomeAdvertiseMapper {

    List<HomeAdvertise> select(HomeAdvertise advertise);
}
