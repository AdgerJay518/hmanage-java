package com.manage.controller;

import com.manage.common.api.CommonResult;
import com.manage.domin.FmsFoodCategoryNode;
import com.manage.domin.FmsPortalFoodDetail;
import com.manage.domin.PmsPortalSportDetail;
import com.manage.domin.SmsSportCategoryNode;
import com.manage.mapper.FmsFoodCategoryMapper;
import com.manage.service.FmsPortalFoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jonyon on 2021/10/15.
 */
@Controller
@Api(tags = "小程序端食物管理")
@RequestMapping("/food")
public class FmsPortalFoodController {
    @Autowired
    private FmsPortalFoodService foodService;


    @ApiOperation("以树形结构获取所有食品分类")
    @RequestMapping(value = "/categoryTreeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<FmsFoodCategoryNode>> categoryTreeList() {
        List<FmsFoodCategoryNode> list = foodService.categoryTreeList();
        return CommonResult.success(list);
    }

    @ApiOperation("获取食品详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<FmsPortalFoodDetail> detail(@PathVariable Long id) {
        FmsPortalFoodDetail productDetail = foodService.detail(id);
        return CommonResult.success(productDetail);
    }
}
