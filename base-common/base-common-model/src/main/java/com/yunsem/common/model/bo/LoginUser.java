package com.yunsem.common.model.bo;

import lombok.Data;

/**
 * @author yangsen
 * @version 1.0
 * @since 2021-07-22
 */
@Data
public class LoginUser {
    private Long id;
    private String code;
    private String username;
    private String realName;
}
