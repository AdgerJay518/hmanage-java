package com.manage.controller;

import com.manage.common.api.CommonResult;
import com.manage.domin.PmsPortalSportDetail;
import com.manage.domin.SmsSportCategoryNode;
import com.manage.service.SmsPortalSportService;
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
 * 小程序端运动管理
 * Created by jonyon on 2021/9/8.
 */
@Controller
@Api(tags = "小程序端运动管理")
@RequestMapping("/sport")
public class SmsPortalSportController {
    @Autowired
    private SmsPortalSportService portalSportService;

    @ApiOperation("以树形结构获取所有运动分类")
    @RequestMapping(value = "/categoryTreeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsSportCategoryNode>> categoryTreeList() {
        List<SmsSportCategoryNode> list = portalSportService.categoryTreeList();
        return CommonResult.success(list);
    }

    @ApiOperation("获取运动详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsPortalSportDetail> detail(@PathVariable Long id) {
        PmsPortalSportDetail productDetail = portalSportService.detail(id);
        return CommonResult.success(productDetail);
    }
}
