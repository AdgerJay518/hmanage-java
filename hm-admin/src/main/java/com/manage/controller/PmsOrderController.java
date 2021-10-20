package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.dto.PmsOrderQueryParam;
import com.manage.model.PmsOrder;
import com.manage.service.PmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jonyon on 2021/10/18.
 */
@Controller
@Api(tags = "运动计划表单管理")
@RequestMapping("/order")
public class PmsOrderController {
    @Autowired
    private PmsOrderService orderService;

    @ApiOperation("查询所有记录")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsOrder>> list(PmsOrderQueryParam queryParam,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsOrder> orderList = orderService.list(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderList));
    }
}
