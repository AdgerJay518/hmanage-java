package com.manage.controller;

import com.manage.common.api.CommonResult;
import com.manage.dto.OrderFoodParam;
import com.manage.service.PmsPortalOrderFoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@Api(tags = "饮食记录管理")
@RequestMapping("/orderFood")
public class PmsPortalOrderFoodController {
    @Autowired
    private PmsPortalOrderFoodService pmsPortalOrderFoodService;

    @ApiOperation("根据计划信息生成饮食记录")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateOrder(@RequestBody OrderFoodParam orderFoodParam) {
        Map<String, Object> result = pmsPortalOrderFoodService.generateOrder(orderFoodParam);
        return CommonResult.success(result, "成功");
    }
}
