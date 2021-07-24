package com.yungsem.mdm.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yunsem.common.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户
 *
 * @author yangsen
 * @version 1.0
 * @since 2020-08-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user")
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String realName;
}
