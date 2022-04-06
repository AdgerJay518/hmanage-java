package com.manage.service.impl;

import com.manage.mapper.UmsMemberExtendsMapper;
import com.manage.model.UmsMemberExtends;
import com.manage.service.UmsMemberExtendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jonyon on 2022/3/5.
 */
@Service
public class UmsMemberExtendsServiceImpl implements UmsMemberExtendsService {
    @Autowired
    private UmsMemberExtendsMapper umsMemberExtendsMapper;

    @Override
    public UmsMemberExtends getExtendsInfo(Long id) {
        return umsMemberExtendsMapper.getExtendsInfo(id);
    }

    @Override
    public int update(UmsMemberExtends umsMemberExtends) {
        return umsMemberExtendsMapper.update(umsMemberExtends);
    }

    @Override
    public String calculate(String height, String weight) {
        double h = Double.parseDouble(height)/100;
        double w = Double.parseDouble(weight);
        double bmi=w/h/h;
        if (bmi<=18.4&&bmi>=1.0){
            return "偏瘦";
        }
        if (bmi>=18.5&&bmi<=23.9){
            return "正常";
        }
        if (bmi>=24.0&&bmi<=27.9){
            return "过胖";
        }
        if (bmi>=28&&bmi<=32){
            return "肥胖";
        }
        return "请输入正确的身高、体重！";
    }
}
