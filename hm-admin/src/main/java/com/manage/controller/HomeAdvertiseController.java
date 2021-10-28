package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.model.HomeAdvertise;
import com.manage.service.HomeAdvertiseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("获取广告详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<HomeAdvertise> getItem(@PathVariable Long id) {
        HomeAdvertise advertise = advertiseService.getItem(id);
        return CommonResult.success(advertise);
    }

    @ApiOperation("修改上下线状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, Integer status) {
        int count = advertiseService.updateStatus(id, status);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("添加广告")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody HomeAdvertise advertise) {
        int count = advertiseService.create(advertise);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除广告")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<Long> ids) {
        int count = advertiseService.delete(ids);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改广告")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody HomeAdvertise advertise) {
        int count = advertiseService.update(id, advertise);
        if (count > 0)
            return CommonResult.success(count);
        return CommonResult.failed();
    }
}
