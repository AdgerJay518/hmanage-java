package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.dto.UmsMenuNode;
import com.manage.model.UmsMenu;
import com.manage.service.UmsMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单管理Controller
 * @author 吴政杰
 */
@Controller
@Api(tags = "后台菜单管理")
@RequestMapping("/menu")
public class UmsMenuController {
    @Autowired
    private UmsMenuService umsMenuService;

    @ApiOperation(value = "分页查询后台菜单")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsMenu>> list(@PathVariable Long parentId,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<UmsMenu> list = umsMenuService.list(parentId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("返回树形结构菜单列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsMenuNode>> treeList() {
        List<UmsMenuNode> list = umsMenuService.treeList();
        return CommonResult.success(list);
    }

    @ApiOperation("菜单是否显示")
    @RequestMapping(value = "/updateHidden/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateHidden(@PathVariable Long id,@RequestParam("hidden") Integer hidden){
        int i = umsMenuService.updateHidden(id, hidden);
        if (i>0){
            return CommonResult.success(i);
        }
        return CommonResult.failed();
    }

    @ApiOperation("根据id获取菜单")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UmsMenu> getItem(@PathVariable Long id){
        UmsMenu item = umsMenuService.getItem(id);
        return CommonResult.success(item);
    }

    @ApiOperation("根据id修改菜单信息")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id,@RequestBody UmsMenu umsMenu){
        int update = umsMenuService.update(id, umsMenu);
        if (update>0){
            return CommonResult.success(update);
        }
        return CommonResult.failed();
    }

    @ApiOperation("新建后台菜单")
    @RequestMapping(value = "/create" ,method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsMenu umsMenu){
        int i = umsMenuService.create(umsMenu);
        if (i>0){
            return CommonResult.success(i);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除后台菜单")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id){
        int delete = umsMenuService.delete(id);
        if (delete>0){
            return CommonResult.success(delete);
        }
        return CommonResult.failed();
    }
}
