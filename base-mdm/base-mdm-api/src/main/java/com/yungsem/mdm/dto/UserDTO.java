package com.yungsem.mdm.dto;

import lombok.Data;

/**
 * @author yangsen
 * @version 1.0
 * @since 2021-07-22
 */
@Data
public class UserDTO {
    private Long id;
    private String code;
    private String username;
    private String realName;
    private String password;
}
