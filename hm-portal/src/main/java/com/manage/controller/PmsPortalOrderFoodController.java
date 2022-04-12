package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.domin.PmsOrderFoodDetail;
import com.manage.dto.OrderFoodParam;
import com.manage.service.PmsPortalOrderFoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("分页获取饮食情况列表")
    @ApiImplicitParam(
            name = "status",
            value = "状态：0->待执行；1->正在执行；2->已完成；3->已关闭；4->无效计划",
            defaultValue = "-1",
            allowableValues = "-1,0,1,2,3,4",
            paramType = "query",
            dataType = "int")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsOrderFoodDetail>> list(@RequestParam Integer status,
                                                             @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                             @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        CommonPage<PmsOrderFoodDetail> orderPage = pmsPortalOrderFoodService.list(status,pageNum,pageSize);
        return CommonResult.success(orderPage);
    }
}
