package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.model.CmsSubjectCategory;
import com.manage.service.CmsSubjectCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
