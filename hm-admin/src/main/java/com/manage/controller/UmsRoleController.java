package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.model.UmsRole;
import com.manage.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理Controller
 * Created by jonyon on 2021/6/25.
 */
@Controller
@Api(tags = "后台角色管理")
@RequestMapping("/role")
public class UmsRoleController {

    @Autowired
    private UmsRoleService umsRoleService;

    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsRole>> listAll(){
        List<UmsRole> list = umsRoleService.list();
        return CommonResult.success(list);
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<UmsRole> list = umsRoleService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("修改角色状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status){
        UmsRole umsRole = new UmsRole();
        umsRole.setStatus(status);
        int update = umsRoleService.update(id, umsRole);
        if (update>0){
            return CommonResult.success(update);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改角色")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,@RequestBody UmsRole umsRole){
        int update = umsRoleService.update(id, umsRole);
        if (update>0){
            return CommonResult.success(update);
        }
        return CommonResult.failed();
    }

    @ApiOperation("创建角色")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsRole umsRole){
        int update = umsRoleService.create(umsRole);
        if (update>0){
            return CommonResult.success(update);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除角色信息")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
        int delete = umsRoleService.delete(id);
        if (delete>0){
            return CommonResult.success(delete);
        }
        return CommonResult.failed();
    }
}
