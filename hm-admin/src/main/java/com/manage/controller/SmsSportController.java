package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.dto.SmsSportQueryParam;
import com.manage.model.SmsSport;
import com.manage.service.SmsSportService;
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

    @ApiOperation("查询商品")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsSport>> getList(SmsSportQueryParam sportQueryParam,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<SmsSport> productList = smsSportService.list(sportQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productList));
    }
}
