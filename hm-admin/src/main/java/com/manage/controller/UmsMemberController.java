package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.model.UmsAdmin;
import com.manage.model.UmsMember;
import com.manage.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jonyon on 2021/11/2.
 */
@Controller
@Api(tags = "用户管理")
@RequestMapping("/member")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation(value="根据用户名分页获取用户列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsMember>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<UmsMember> list = memberService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("修改帐号状态")
    @RequestMapping(value = "/updateStatus/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id
            ,@RequestParam(value = "status") Integer status ){
        UmsMember umsMember = new UmsMember();
        umsMember.setStatus(status);
        int update = memberService.updateStatus(id, umsMember);
        if (update>0){
            return CommonResult.success(update);
        }
        return CommonResult.failed();
    }

    @ApiOperation("注销用户信息")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult delete(@PathVariable Long id){
        int delete = memberService.delete(id);
        if (delete>0){
            return CommonResult.success(delete);
        }
        return CommonResult.failed();
    }
}
