package com.yungsem.mdm.business.service.remote;

import cn.hutool.core.bean.BeanUtil;
import com.yungsem.mdm.domain.entity.User;
import com.yungsem.mdm.domain.service.UserService;
import com.yungsem.mdm.dto.UserDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户模块 feign 端业务
 *
 * @author yangsen
 * @version 1.0
 * @since 2020-08-16
 */
@Service
public class RemoteUserService {
    @Resource
    private UserService userService;

    public UserDTO getUserByUsername(String username) {
        User user = userService.getByUsername(username);
        UserDTO userDTO = new UserDTO();
        BeanUtil.copyProperties(user, userDTO);
        return userDTO;
    }
}
