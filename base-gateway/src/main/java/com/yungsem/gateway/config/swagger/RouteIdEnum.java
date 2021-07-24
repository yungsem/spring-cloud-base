package com.yungsem.gateway.config.swagger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author yangsen
 * @version 1.0
 * @since 2021-07-24
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum RouteIdEnum {

    BASE_AUTH("base-auth", "认证中心"),
    BASE_MDM("base-mdm-biz", "主数据管理服务"),
    ;

    public static String parseId(String id) {
        for (RouteIdEnum routeIdEnum : RouteIdEnum.values()) {
            if (routeIdEnum.getId().equals(id)) {
                return routeIdEnum.getName();
            }
        }
        return "未知";
    }
    private String id;
    private String name;
}
