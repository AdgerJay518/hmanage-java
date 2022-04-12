package com.manage.controller;

import com.manage.common.api.CommonResult;
import com.manage.dto.PlanItemParam;
import com.manage.dto.PlanItemParams;
import com.manage.model.PlanItemFood;
import com.manage.service.PlanItemFoodService;
import com.manage.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "饮食计划管理")
@RequestMapping("/planFood")
public class PlanItemFoodController {

    @Autowired
    private PlanItemFoodService planItemFoodService;

    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("添加到饮食")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody PlanItemFood planItemFood) {
        System.out.println(planItemFood);
        int count = planItemFoodService.add(planItemFood);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取饮食")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PlanItemFood>> list() {
        List<PlanItemFood> cartItemList = planItemFoodService.list(memberService.getCurrentMember().getId());
        return CommonResult.success(cartItemList);
    }

    @ApiOperation("修改饮食克数")
    @RequestMapping(value = "/update/quantity", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult updateQuantity(@RequestParam Long id,
                                       @RequestParam Integer quantity) {
        int count = planItemFoodService.updateQuantity(id, memberService.getCurrentMember().getId(), quantity);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除饮食")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestBody PlanItemParam param) {
        int count = planItemFoodService.delete(memberService.getCurrentMember().getId(), param.getId());
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除多条计划")
    @RequestMapping(value = "/deletes", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deletes(@RequestBody PlanItemParams param) {
        int count = planItemFoodService.deletes(memberService.getCurrentMember().getId(), param.getPlanIds());
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
