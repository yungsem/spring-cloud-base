package com.yungsem.mdm.business.controller.system;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.yungsem.mdm.business.service.system.UserBusinessService;
import com.yunsem.common.model.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangsen
 */
@RefreshScope
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class UserBusinessController {
    @Resource
    private UserBusinessService userBusinessService;

    /**
     * 批量新增
     *
     * @return R
     */
    @PostMapping("/createBatch")
    @ApiOperation(value = "批量新增1")
    public R<Boolean> createBatch() {
        return R.ok();
    }

    /**
     * 批量新增
     *
     * @return R
     */
    @PostMapping("/createBatch2")
    @ApiOperation(value = "批量新增2")
    public R<Boolean> createBatch2() {
        return R.ok();
    }
}
