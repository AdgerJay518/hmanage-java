package com.manage.controller;

import com.manage.common.api.CommonPage;
import com.manage.common.api.CommonResult;
import com.manage.component.DynamicSecurityMetadataSource;
import com.manage.model.UmsResource;
import com.manage.model.UmsRole;
import com.manage.service.UmsResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资源管理Controller
 * Created by jonyon on 2021/6/27.
 */
@Controller
@Api(tags = "后台资源管理")
@RequestMapping("/resource")
public class UmsResourceController {
    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;
    @Autowired
    private UmsResourceService umsResourceService;

    @ApiOperation("分页查询后台资源")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsResource>> list(@RequestParam(required = false) Long categoryId,
                                                      @RequestParam(required = false) String nameKeyword,
                                                      @RequestParam(required = false) String urlKeyword,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        List<UmsResource> list = umsResourceService.list(categoryId, nameKeyword, urlKeyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("查询所有后台资源")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsResource>> listAll(){
        List<UmsResource> umsResources = umsResourceService.listAll();
        return CommonResult.success(umsResources);
    }

    @ApiOperation("修改后台资源信息")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody UmsResource umsResource){
        int update = umsResourceService.update(id, umsResource);
        //后台资源发生变化时，清空缓存在Map对象中的后台资源规则数据
        dynamicSecurityMetadataSource.clearDataSource();
        if (update>0){
            return CommonResult.success(update);
        }
        return CommonResult.failed();
    }
}
