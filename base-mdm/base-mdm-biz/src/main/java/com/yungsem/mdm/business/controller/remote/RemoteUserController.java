package com.yungsem.mdm.business.controller.remote;

import com.yungsem.mdm.business.service.remote.RemoteUserService;
import com.yungsem.mdm.dto.UserDTO;
import com.yungsem.security.annotation.AuthIgnore;
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
public class RemoteUserController {
    @Resource
    private RemoteUserService remoteUserService;

    @AuthIgnore
    @GetMapping("/getByUsername")
    public UserDTO getUserByUsername(@RequestParam(value = "username") String username) {
        return remoteUserService.getUserByUsername(username);
    }
}
