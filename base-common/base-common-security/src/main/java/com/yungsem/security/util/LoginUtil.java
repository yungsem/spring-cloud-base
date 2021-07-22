package com.yungsem.security.util;

import com.yunsem.common.model.bo.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Map;

/**
 * @author yangsen
 * @version 1.0
 * @since 2020-08-17
 */
public class LoginUtil {

    /**
     * 获取当前登录用户
     *
     * @return UserEntity
     */
    public static LoginUser getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) principal;
            LoginUser user = new LoginUser();
            user.setUsername((String) map.get("username"));
            user.setRealName((String) map.get("realName"));
            user.setId(Long.valueOf((Integer) map.get("id")));
            user.setCode((String) map.get("code"));
            return user;
        } else {
            LoginUser user = new LoginUser();
            user.setCode("anonymous");
            user.setUsername("anonymous");
            user.setRealName("匿名");
            return user;
        }
    }
}
