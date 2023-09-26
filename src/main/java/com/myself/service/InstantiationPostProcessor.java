package com.myself.service;

import com.alibaba.spring.beans.factory.annotation.AbstractAnnotationBeanPostProcessor;
import com.myself.service.impl.Jack;
import com.myself.service.impl.JackProxy;
import net.sf.cglib.proxy.Enhancer;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.*;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.stereotype.Component;


/**
 * 实现在 populateBean 阶段 InstantiationAwareBeanPostProcessor 自定义注解解析，代理生成。
 * @see AbstractAutowireCapableBeanFactory#applyMergedBeanDefinitionPostProcessors(RootBeanDefinition, Class, String)
 * @see MergedBeanDefinitionPostProcessor
 * doCreateBean 创建 Bean 时,在 populateBean、initializeBean 赋值属性，初始化Bean 之前调用
 * 一帮用于对 Bean 属性收集 @value @NacaosValue
 * ->applyMergedBeanDefinitionPostProcessors
 * , 对 beanDefinition 信息收集，例如 @Value 信息收集
 * ->MergedBeanDefinitionPostProcessor
 * <p>
 * BeanFactoryAware, BeanClassLoaderAware, EnvironmentAware, DisposableBean
 * @see InstantiationAwareBeanPostProcessor 一般与其配合使用,感知Bean 实例化的处理器。
 * @see AbstractAutowireCapableBeanFactory#createBean(String, RootBeanDefinition, Object[])
 * args)
 * createBean -> resolveBeforeInstantiation -> doCreateBean
 * <p>
 * 在创建Bean 之前，调用，如果返回了对象，就执行 postProcessAfterInstantiation，（自行实现 Bean 创建的场景）
 * <p>
 * 或者手动生成代理类
 * <p>
 * <p>
 * 实现自定义 Autowire 注解注入 ,属性赋值是，解析自定义 注解赋值
 * @see AbstractAutowireCapableBeanFactory#populateBean(String, RootBeanDefinition, BeanWrapper)
 * -> InstantiationAwareBeanPostProcessor ->postProcessPropertyValues
 * populateBean->postProcessPropertyValues->
 * AbstractAnnotationBeanPostProcessor->postProcessPropertyValues
 * <p>
 * InjectionMetadata 解析出来 Bean 包含的注解的属性-> findInjectionMetadata-> inject 注入
 */
@Component
public class InstantiationPostProcessor extends AbstractAnnotationBeanPostProcessor {
    InstantiationPostProcessor() {
        super(Jack.class);
    }

    /**
     * @param attributes      {@link AnnotationAttributes the annotation attributes}
     * @param bean            Current bean that will be injected  被注入属性的 Bean
     * @param beanName        Current bean name that will be injected
     * @param injectedType    the type of injected-object
     * @param injectedElement {@link InjectionMetadata.InjectedElement}
     * @return
     * @throws Exception
     */
    @Override
    protected Object doGetInjectedBean(AnnotationAttributes attributes, Object bean, String beanName, Class<?> injectedType, InjectionMetadata.InjectedElement injectedElement) throws Exception {

        // 构建自定义注解的 处理 代理对象。
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
        // 构建代理类 beanDefinition
        beanDefinitionBuilder.getBeanDefinition().setInstanceSupplier(() -> {
                    Enhancer enhancer = new Enhancer();
                    enhancer.setSuperclass(injectedType);
                    enhancer.setCallback(new JackProxy());
                    Object o = enhancer.create();
                    return injectedType.cast(o);
                }
        );
        //
        String newBeanName = injectedType.getName() + "$proxy";
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 第一没获取到， 注入 beanDefinition 再次初始化 bean
        try {

            return beanFactory.getBean(newBeanName);

        } catch (BeansException e) {

            BeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
            BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) getBeanFactory();

            beanDefinitionRegistry.registerBeanDefinition(newBeanName, beanDefinition);
            return beanFactory.getBean(newBeanName);
        }

    }

    @Override
    protected String buildInjectedObjectCacheKey(AnnotationAttributes attributes, Object bean, String beanName, Class<?> injectedType, InjectionMetadata.InjectedElement injectedElement) {
        return injectedType.getName();
    }
}
