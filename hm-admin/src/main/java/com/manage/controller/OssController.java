package com.manage.controller;

import com.manage.common.api.CommonResult;
import com.manage.dto.OssCallbackResult;
import com.manage.dto.OssPolicyResult;
import com.manage.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *Oss相关操作接口
 * @author jonyon
 * @date 2021/8/16
 */
@Controller
@Api(tags = "Oss管理")
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @ApiOperation(value = "Oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<OssPolicyResult> policy() {
        OssPolicyResult result = ossService.policy();
        System.out.println("policy");
        return CommonResult.success(result);
    }

    @ApiOperation(value = "Oss上传成功回调")
    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<OssCallbackResult> callback(HttpServletRequest request) {
        System.out.println("callback--start");
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        System.out.println("callback--end");
        return CommonResult.success(ossCallbackResult);
    }
}
