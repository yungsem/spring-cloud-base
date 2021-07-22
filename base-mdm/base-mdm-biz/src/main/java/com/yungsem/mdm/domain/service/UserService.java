package com.yungsem.mdm.domain.service;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yungsem.mdm.domain.entity.User;
import com.yungsem.mdm.domain.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author yangsen
 * @version 1.0
 * @since 2021-07-22
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    /**
     * 获取
     *
     * @param username 用户名
     * @return User
     */
    public User getByUsername(String username) {
        LambdaQueryWrapper<User> qw = Wrappers.<User>lambdaQuery()
                .eq(User::getUsername, username);
        return CollectionUtil.getFirst(this.list(qw));
    }
}
