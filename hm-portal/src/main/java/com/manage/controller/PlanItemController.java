package com.manage.controller;

import com.manage.common.api.CommonResult;
import com.manage.dto.PlanItemParam;
import com.manage.dto.PlanItemParams;
import com.manage.model.PlanItem;
import com.manage.service.PlanItemService;
import com.manage.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jonyon on 2021/10/7.
 */
@Controller
@Api(tags = "计划管理")
@RequestMapping("/plan")
public class PlanItemController {
    @Autowired
    private PlanItemService planItemService;

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("添加到计划")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody PlanItem planItem) {
        int count = planItemService.add(planItem);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取用户的计划列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PlanItem>> list() {
        List<PlanItem> cartItemList = planItemService.list(memberService.getCurrentMember().getId());
        return CommonResult.success(cartItemList);
    }

    @ApiOperation("修改计划列表中sf数量")
    @RequestMapping(value = "/update/quantity", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateQuantity(@RequestParam Long id,
                                       @RequestParam Integer quantity) {
        int count = planItemService.updateQuantity(id, memberService.getCurrentMember().getId(), quantity);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除某一条计划")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestBody PlanItemParam param) {
        int count = planItemService.delete(memberService.getCurrentMember().getId(), param.getId());
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除多条计划")
    @RequestMapping(value = "/deletes", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deletes(@RequestBody PlanItemParams param) {
        int count = planItemService.deletes(memberService.getCurrentMember().getId(), param.getPlanIds());
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
