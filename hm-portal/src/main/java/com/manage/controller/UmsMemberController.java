package com.manage.controller;

import com.manage.common.api.CommonResult;
import com.manage.dto.UmsMemberLoginParam;
import com.manage.model.UmsMember;
import com.manage.model.UmsMemberExtends;
import com.manage.service.UmsMemberExtendsService;
import com.manage.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonyon on 2021/9/12.
 */
@Controller
@Api(tags = "登录注册管理")
@RequestMapping("/member")
public class UmsMemberController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsMemberService memberService;

    @Autowired
    private UmsMemberExtendsService umsMemberExtendsService;

    private boolean flag=false;

    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsMemberLoginParam member){
        String username = member.getUsername();
        String password = member.getPassword();
        String token = memberService.login(username, password);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult info(Principal principal) {
        if(principal==null){
            return CommonResult.unauthorized(null);
        }
        UmsMember member = memberService.getCurrentMember();
        flag=true;
        return CommonResult.success(member);
    }

    @ApiOperation("获取更多用户信息")
    @RequestMapping(value = "/ExtendsInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult info(Long id){
        if (!flag){
            return CommonResult.unauthorized(null);
        }
        UmsMemberExtends umsMemberExtends=umsMemberExtendsService.getExtendsInfo(id);
        System.out.println(umsMemberExtends);
        return CommonResult.success(umsMemberExtends);
    }

    @ApiOperation("修改用户信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@RequestBody UmsMember member) {
        int count = memberService.update(member);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改用户扩展信息")
    @RequestMapping(value = "/updateExtends", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateExtends(@RequestBody UmsMemberExtends umsMemberExtends) {
        int count = umsMemberExtendsService.update(umsMemberExtends);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据身高体重判断健康状况")
    @RequestMapping(value = "/healthLevel", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult healthLevel(@RequestParam (value = "height") String height,@RequestParam (value = "weight") String weight) {
        String healthLevel = umsMemberExtendsService.calculate(height,weight);
        return CommonResult.success(healthLevel);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }
}
