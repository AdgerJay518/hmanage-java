package com.manage.controller;

import com.manage.common.api.CommonResult;
import com.manage.model.UmsAdmin;
import com.manage.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 菜单管理Controller
 * @author 吴政杰
 */
@Controller
@Api(tags = "后台菜单管理")
@RequestMapping("/menu")
public class UmsMenuController {
    @Autowired
    private UmsAdminService service;

    @ApiOperation(value = "测试接口1")
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('2:后台角色管理')")
    public CommonResult getAdminByUsername1(){
        UmsAdmin test = service.getAdminByUsername("adger");
        return CommonResult.success(test);
    }

    @ApiOperation(value = "测试接口2")
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminByUsername(){
        UmsAdmin test = service.getAdminByUsername("test");
        return CommonResult.success(test);
    }
}
