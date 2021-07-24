package com.yungsem.mdm.business.controller.remote;

import com.yungsem.mdm.business.service.remote.UserRemoteService;
import com.yungsem.mdm.dto.UserDTO;
import com.yungsem.security.annotation.AuthIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangsen
 */
@RefreshScope
@RestController
@RequestMapping("/remote/user")
@Api(tags = "用户管理-远程调用")
public class UserRemoteController {
    @Resource
    private UserRemoteService userRemoteService;

    @AuthIgnore
    @GetMapping("/getByUsername")
    @ApiOperation(value = "获取认证用户")
    public UserDTO getUserByUsername(@RequestParam(value = "username") String username) {
        return userRemoteService.getUserByUsername(username);
    }
}
