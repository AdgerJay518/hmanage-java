package com.manage.controller;

import com.manage.common.api.CommonResult;
import com.manage.dto.UmsAdminLoginParam;
import com.manage.pojo.UmsAdmin;
import com.manage.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
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
@Api(tags = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
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

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        String token = service.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());

        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
}
