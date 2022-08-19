package com.mingshashan.practice.spring.ioc.denpendency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareInterfaceDependencyInjectionDemo implements BeanFactoryAware, ApplicationContextAware {

    private static BeanFactory beanFactory;
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册Configuration Class(配置类) -> Spring Bean
        applicationContext.register(AwareInterfaceDependencyInjectionDemo.class);

        // 启动Spring应用上下文
        applicationContext.refresh();

        System.out.println(beanFactory == applicationContext.getBeanFactory());

        // 关闭Spring应用上下文
        applicationContext.close();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AwareInterfaceDependencyInjectionDemo.applicationContext = applicationContext;
    }
}
