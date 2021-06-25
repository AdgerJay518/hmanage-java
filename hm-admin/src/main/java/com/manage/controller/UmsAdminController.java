package com.manage.controller;

import cn.hutool.core.collection.CollUtil;
import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.dto.UmsAdminLoginParam;
import com.manage.dto.UmsAdminParam;
import com.manage.model.UmsAdmin;
import com.manage.model.UmsResource;
import com.manage.model.UmsRole;
import com.manage.service.UmsAdminService;
import com.manage.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Autowired
    private UmsRoleService roleService;


    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsAdmin> register(@Validated @RequestBody UmsAdminParam umsAdminParam){
        UmsAdmin register = service.register(umsAdminParam);
        if (register==null){
            return CommonResult.failed();
        }
        return CommonResult.success(register);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation(value = "根据用户名查找用户")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminByUsername(){
        Map<String, Object> data = new HashMap<>();
        UmsAdmin test = service.getAdminByUsername("Adger");
        List<UmsResource> resourceList = service.getResourceList(test.getId());
        data.put("username",test.getUsername());
        data.put("nickName",test.getNickName());
        data.put("createTime",test.getCreateTime());
        data.put("List",resourceList);
        return CommonResult.success(data);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo(Principal principal){
        if (principal==null){
            return CommonResult.unauthorized(null);
        }
        String name = principal.getName();
        UmsAdmin adminByUsername = service.getAdminByUsername(name);
        Map<String,Object> map=new HashMap<>();
        map.put("username",adminByUsername.getUsername());
        map.put("icon",adminByUsername.getIcon());
        map.put("menus",roleService.getMenuList(adminByUsername.getId()));
        List<UmsRole> roleList = service.getRoleList(adminByUsername.getId());
        if (CollUtil.isNotEmpty(roleList)){
            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
            map.put("roles",roles);
        }
        return CommonResult.success(map);
    }

    @ApiOperation(value="根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsAdmin>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<UmsAdmin> list = service.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
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

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getById(@PathVariable Long id){
        UmsAdmin byId = service.getById(id);
        return CommonResult.success(byId);
    }

    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
        int count = service.update(id, admin);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult delete(@PathVariable Long id){
        int delete = service.delete(id);
        if (delete>0){
            return CommonResult.success(delete);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改帐号状态")
    @RequestMapping(value = "/updateStatus/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id
            ,@RequestParam(value = "status") Integer status ){
        UmsAdmin admin = new UmsAdmin();
        admin.setStatus(status);
        int update = service.update(id, admin);
        if (update>0){
            return CommonResult.success(update);
        }
        return CommonResult.failed();
    }

   @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsRole>> getRoleList(@PathVariable Long adminId){
       List<UmsRole> roleList = service.getRoleList(adminId);
       return CommonResult.success(roleList);
   }

   @ApiOperation("分配角色")
   @RequestMapping(value = "/role/update",method = RequestMethod.POST)
   @ResponseBody
   public CommonResult updateRole(@RequestParam("adminId") Long adminId,
                                  @RequestParam("roleId") List<Long> roleId){
       return CommonResult.failed();
   }
}
