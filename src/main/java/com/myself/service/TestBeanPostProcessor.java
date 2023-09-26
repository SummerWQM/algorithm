package com.myself.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 实例化后，初始化阶段调用
 *
 * @see AbstractAutowireCapableBeanFactory( DefaultListableBeanFactory 、
 * AbstractAutowireCapableBeanFactory)
 * initializeBean
 * -> invokeAwareMethods 调用 Aware 方法，赋值 applicationContext 、beanFactory 、environment
 * -> applyBeanPostProcessorsBeforeInitialization 初始化前调用
 * -> invokeInitMethods  @PostConstruct
 * -> applyBeanPostProcessorsBeforeInitialization 初始化后调用
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor, BeanFactoryAware {

    private static boolean MOAT_ENABLE = false;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {


        System.out.println(beanName);
        return bean;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        MOAT_ENABLE = true;
    }
}
