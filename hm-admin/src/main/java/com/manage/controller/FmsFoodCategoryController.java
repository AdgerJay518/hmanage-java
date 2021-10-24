package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.model.FmsFoodCategory;
import com.manage.model.SmsSportCategory;
import com.manage.service.FmsFoodCategoryService;
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
 * @date 2021/10/24
 */
@Controller
@Api(tags = "食品分类管理")
@RequestMapping("/foodCategory")
public class FmsFoodCategoryController {
    @Autowired
    private FmsFoodCategoryService foodCategory;

    @ApiOperation("分页查询食品分类")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<FmsFoodCategory>> getList(@PathVariable Long parentId,
                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<FmsFoodCategory> list = foodCategory.getList(parentId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("修改导航栏显示状态")
    @RequestMapping(value = "/update/navStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateNavStatus(@PathVariable Long id, @RequestParam("navStatus") Integer navStatus) {
        int count = foodCategory.updateNavStatus(id, navStatus);
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
        int count = foodCategory.updateShowStatus(id, showStatus);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据id获取食品分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<FmsFoodCategory> getItem(@PathVariable Long id) {
        FmsFoodCategory category = foodCategory.getItem(id);
        return CommonResult.success(category);
    }

    @ApiOperation("修改食品分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @Validated
                               @RequestBody FmsFoodCategory foodCategoryParam) {
        int count = foodCategory.update(id, foodCategoryParam);
        System.out.println(count);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("添加运动分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@Validated @RequestBody FmsFoodCategory FoodCategory) {
        int count = foodCategory.create(FoodCategory);
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
        int count = foodCategory.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

//    @ApiOperation("查询所有分类及其子分类")
//    @RequestMapping(value = "/list/withChildren", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<List<FmsFoodCategoryWithChildren>> listWithChildren() {
//        List<FmsFoodCategoryWithChildren> list = foodCategory.listWithChildren();
//        return CommonResult.success(list);
//    }
}
