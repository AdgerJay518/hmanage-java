package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.model.CmsSubject;
import com.manage.service.CmsSubjectService;
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
 * Created by jonyon on 2021/10/28.
 */
@Controller
@Api(tags = "主题管理")
@RequestMapping("/subject")
public class CmsSubjectController {
    @Autowired
    private CmsSubjectService subjectService;

    @ApiOperation(value = "分页查询主题")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CmsSubject>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<CmsSubject> subjectList = subjectService.list(keyword,pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(subjectList));
    }
}