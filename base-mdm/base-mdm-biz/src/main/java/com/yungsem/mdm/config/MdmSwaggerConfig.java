package com.yungsem.mdm.config;

import com.yungsem.swagger.config.BaseSwaggerConfig;
import com.yungsem.swagger.config.DocketBuilder;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangsen
 * @version 1.0
 * @since 2021-07-24
 */
@Configuration
public class MdmSwaggerConfig extends BaseSwaggerConfig {
    @Override
    public DocketBuilder instantDocketBuilder() {
        String basePackage = "com.yungsem.mdm";
        String title = "主数据管理系统";
        String id = "mdmDocket";
        return new DocketBuilder(basePackage, title, id);
    }
}
