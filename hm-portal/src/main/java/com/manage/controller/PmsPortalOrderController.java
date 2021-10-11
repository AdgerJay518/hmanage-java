package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.domin.PlanItemList;
import com.manage.domin.PmsOrderDetail;
import com.manage.dto.OrderParam;
import com.manage.model.PlanItem;
import com.manage.service.PmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by jonyon on 2021/10/9.
 */
@Controller
@Api(tags = "计划单管理")
@RequestMapping("/order")
public class PmsPortalOrderController {

    @Autowired
    private PmsPortalOrderService pmsPortalOrderService;

    @ApiOperation("按状态分页获取用户订单列表")
    @ApiImplicitParam(
            name = "status",
            value = "状态：0->待执行；1->正在执行；2->已完成；3->已关闭；4->无效计划",
            defaultValue = "-1",
            allowableValues = "-1,0,1,2,3,4",
            paramType = "query",
            dataType = "int")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsOrderDetail>> list(@RequestParam Integer status,
                                                         @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                         @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        CommonPage<PmsOrderDetail> orderPage = pmsPortalOrderService.list(status,pageNum,pageSize);
        return CommonResult.success(orderPage);
    }

    @ApiOperation("根据计划信息生成计划单")
    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateOrder(@RequestBody OrderParam orderParam) {
        Map<String, Object> result = pmsPortalOrderService.generateOrder(orderParam);
        System.out.println(result);
        return CommonResult.success(result, "成功");
    }

    @ApiOperation("test")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult test(@RequestBody OrderParam orderParam) {
        //System.out.println(orderParam);
        List<PlanItem> test = pmsPortalOrderService.test(orderParam);
        return CommonResult.success(null, "成功");
    }
}
