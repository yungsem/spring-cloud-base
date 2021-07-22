package com.yungsem.mdm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@MapperScan("com.yungsem.baserbacbiz.mapper")
@EnableResourceServer // 开启资源保护
@EnableCaching
@SpringBootApplication
@EnableDiscoveryClient
public class BaseMdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseMdmApplication.class, args);
    }

}
