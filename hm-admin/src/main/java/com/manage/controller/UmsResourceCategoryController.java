package com.manage.controller;

import com.manage.common.api.CommonResult;
import com.manage.model.UmsResourceCategory;
import com.manage.service.UmsResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源分类管理Controller
 * Created by jonyon on 2021/6/27.
 */
@Controller
@Api(tags = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Autowired
    private UmsResourceCategoryService resourceCategoryService;

    @ApiOperation("查询所有后台资源分类")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResourceCategory>> listAll() {
        List<UmsResourceCategory> resourceList = resourceCategoryService.listAll();
        return CommonResult.success(resourceList);
    }

    @ApiOperation("修改后台资源分类")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @RequestBody UmsResourceCategory umsResourceCategory){
        int update = resourceCategoryService.update(id,umsResourceCategory);
        if (update>0){
            return CommonResult.success(update);
        }
        return CommonResult.failed();
    }

    @ApiOperation("创建后台资源分类")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsResourceCategory umsResourceCategory){
        int i = resourceCategoryService.create(umsResourceCategory);
        if (i>0){
            return CommonResult.success(i);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据id删除后台资源")
    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
        int delete = resourceCategoryService.delete(id);
        if (delete>0){
            return CommonResult.success(delete);
        }
        return CommonResult.failed();
    }
}
