package com.yungsem.swagger.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangsen
 * @version 1.0
 * @since 2021-07-24
 */
@Configuration
public abstract class BaseSwaggerConfig implements BeanFactoryAware {
    /**
     * 创建 Docket ，并注册到 Spring 容器中
     *
     * @param beanFactory beanFactory
     * @throws BeansException BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory listableBeanFactory = (DefaultListableBeanFactory) beanFactory;
        DocketBuilder docketBuilder = instantDocketBuilder();
        if (!listableBeanFactory.containsBean(docketBuilder.getBeanName())) {
            listableBeanFactory.registerSingleton(docketBuilder.getBeanName(), docketBuilder.buildDocket());
        }
    }

    /**
     * 创建 DocketBuilder
     *
     * @return DocketBuilder
     */
    public abstract DocketBuilder instantDocketBuilder();
}
