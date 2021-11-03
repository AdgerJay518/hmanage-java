package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.model.CmsSubjectCategory;
import com.manage.service.CmsSubjectCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jonyon on 2021/10/28.
 */
@Controller
@Api(tags = "主题分类管理")
@RequestMapping("/subjectCategory")
public class CmsSubjectCategoryController {
    @Autowired
    private CmsSubjectCategoryService subjectCategoryService;

    @ApiOperation(value = "分页查询主题")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CmsSubjectCategory>> getList(@RequestParam(value = "subjectName", required = false) String subjectName,
                                                                @RequestParam(value = "recommendStatus", required = false) Integer recommendStatus,
                                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<CmsSubjectCategory> subjectList = subjectCategoryService.list(subjectName, recommendStatus, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(subjectList));
    }

    @ApiOperation("批量修改推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                              @RequestParam Integer recommendStatus) {
        int count = subjectCategoryService.updateRecommendStatus(ids, recommendStatus);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


    @ApiOperation("修改推荐排序")
    @RequestMapping(value = "/update/sort/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateSort(@PathVariable Long id, Integer sort) {
        int count = subjectCategoryService.updateSort(id, sort);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("批量删除")
    @RequestMapping(value = "/home/subject/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateDeleteStatus(@RequestParam("ids") List<Long> ids) {
        int count = subjectCategoryService.deleteIds(ids);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }


    @ApiOperation("根据id获取主题")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CmsSubjectCategory> getItem(@PathVariable Long id) {
        CmsSubjectCategory cmsSubjectCategory = subjectCategoryService.getItem(id);
        return CommonResult.success(cmsSubjectCategory);
    }

    @ApiOperation("添加主题")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@Validated @RequestBody CmsSubjectCategory cmsSubjectCategory) {
        int count = subjectCategoryService.create(cmsSubjectCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("编辑专题")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @Validated
                               @RequestBody CmsSubjectCategory cmsSubjectCategory) {
        int count = subjectCategoryService.update(id, cmsSubjectCategory);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
