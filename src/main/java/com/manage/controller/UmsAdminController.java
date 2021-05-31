package com.manage.controller;

import com.manage.common.api.CommonResult;
import com.manage.pojo.UmsAdmin;
import com.manage.service.UmsAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理Controller
 * @author 吴政杰
 */
@Controller
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService service;
    @ApiOperation(value = "根据用户名查找用户")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminByUsername(){
        Map<String, Object> data = new HashMap<>();
        UmsAdmin test = service.getAdminByUsername("test");
        data.put("username",test.getUsername());
        data.put("nickName",test.getNickName());
        data.put("createTime",test.getCreateTime());
        return CommonResult.success(data);
    }
}
