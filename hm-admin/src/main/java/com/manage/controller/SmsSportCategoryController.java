package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.dto.SmsSportCategoryWithChildren;
import com.manage.model.SmsSportCategory;
import com.manage.service.SmsSportCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author jonyon
 * @date 2021/8/12
 */
@Controller
@Api(tags = "运动分类管理")
@RequestMapping("/sportCategory")
public class SmsSportCategoryController {
    @Autowired
    private SmsSportCategoryService sportCategory;

    @ApiOperation("分页查询运动分类")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<SmsSportCategory>> getList(@PathVariable Long parentId,
                                                              @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<SmsSportCategory> list = sportCategory.getList(parentId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("修改导航栏显示状态")
    @RequestMapping(value = "/update/navStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateNavStatus(@PathVariable Long id, @RequestParam("navStatus") Integer navStatus) {
        int count = sportCategory.updateNavStatus(id, navStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改显示状态")
    @RequestMapping(value = "/update/showStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateShowStatus(@PathVariable Long id, @RequestParam("showStatus") Integer showStatus) {
        int count = sportCategory.updateShowStatus(id, showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除运动分类")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = sportCategory.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据id获取运动分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SmsSportCategory> getItem(@PathVariable Long id) {
        SmsSportCategory productCategory = sportCategory.getItem(id);
        return CommonResult.success(productCategory);
    }

    @ApiOperation("添加运动分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@Validated @RequestBody SmsSportCategory SportCategory) {
        int count = sportCategory.create(SportCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("修改运动分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @Validated
                               @RequestBody SmsSportCategory sportCategoryParam) {
        int count = sportCategory.update(id, sportCategoryParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("查询所有分类及其子分类")
    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<SmsSportCategoryWithChildren>> listWithChildren() {
        List<SmsSportCategoryWithChildren> list = sportCategory.listWithChildren();
        return CommonResult.success(list);
    }
}
