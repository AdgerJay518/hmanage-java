package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.dto.SmsSportQueryParam;
import com.manage.dto.SmsSportResult;
import com.manage.model.SmsSport;
import com.manage.service.SmsSportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 运动管理Controller
 * @author jonyon
 * @date 2021/8/17
 */
@Controller
@Api(tags = "运动管理")
@RequestMapping("/sport")
public class SmsSportController {

    @Autowired
    private SmsSportService smsSportService;

    @ApiOperation("查询运动")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsSport>> getList(SmsSportQueryParam sportQueryParam,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SmsSport> productList = smsSportService.list(sportQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productList));
    }

    @ApiOperation("根据id获取编辑信息")
    @RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SmsSportResult> getUpdateInfo(@PathVariable Long id) {
        SmsSportResult sportResult = smsSportService.getUpdateInfo(id);
        return CommonResult.success(sportResult);
    }
}
