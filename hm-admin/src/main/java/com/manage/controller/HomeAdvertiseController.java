package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.model.HomeAdvertise;
import com.manage.service.HomeAdvertiseService;
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
 *
 * @author jonyon
 * @date 2021/10/26
 */
@Controller
@Api(tags = "首页轮播广告管理")
@RequestMapping("/home/advertise")
public class HomeAdvertiseController {
    @Autowired
    private HomeAdvertiseService advertiseService;


    @ApiOperation("分页查询广告")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<HomeAdvertise>> list(@RequestParam(value = "name", required = false) String name,
                                                        @RequestParam(value = "type", required = false) Integer type,
                                                        @RequestParam(value = "endTime", required = false) String endTime,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<HomeAdvertise> advertiseList = advertiseService.list(name, type, endTime, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(advertiseList));
    }
}
