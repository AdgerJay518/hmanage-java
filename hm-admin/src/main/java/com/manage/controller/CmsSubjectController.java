package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.model.CmsSubject;
import com.manage.model.CmsSubjectCategory;
import com.manage.model.SmsSportCategory;
import com.manage.service.CmsSubjectService;
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
@Api(tags = "主题管理")
@RequestMapping("/subject")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService subjectService;

    @ApiOperation(value = "根据关键字分页查询主题")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CmsSubject>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<CmsSubject> subjectList = subjectService.list(keyword,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(subjectList));
    }

    @ApiOperation(value = "根据父类id分页查询主题")
    @RequestMapping(value = "/listById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CmsSubject>> getList(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "subjectId", required = false) Long subjectId
    ){
        List<CmsSubject> subjectList = subjectService.listById(pageSize, pageNum,subjectId);
        return CommonResult.success(CommonPage.restPage(subjectList));
    }

    @ApiOperation("根据id获取主题")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CmsSubject> getItem(@PathVariable Long id) {
        CmsSubject cmsSubject = subjectService.getItem(id);
        return CommonResult.success(cmsSubject);
    }

    @ApiOperation("添加主题")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@Validated @RequestBody CmsSubject cmsSubject) {
        int count = subjectService.create(cmsSubject);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("id") long id) {
        int count = subjectService.deleteId(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("编辑主题")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,
                               @Validated @RequestBody CmsSubject cmsSubject) {
        int count = subjectService.update(id, cmsSubject);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
