package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.model.CmsSubjectComment;
import com.manage.service.CmsSubjectCommentService;
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
 * Created by jonyon on 2021/11/2.
 */
@Controller
@Api(tags = "评论管理")
@RequestMapping("/subjectComment")
public class CmsSubjectCommentController {
    @Autowired
    private CmsSubjectCommentService commentService;

    @ApiOperation(value = "根据父类id分页查询主题")
    @RequestMapping(value = "/listById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<CmsSubjectComment>> getList(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "subjectId", required = false) Long subjectId
    ){
        List<CmsSubjectComment> subjectList = commentService.listById(pageSize, pageNum,subjectId);
        return CommonResult.success(CommonPage.restPage(subjectList));
    }
}
