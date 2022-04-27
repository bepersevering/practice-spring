package com.mingshashan.practice.spring.bean.definition;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

//@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 1.BeanFactory容器
        AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext();
        // 注册Configuration Class(配置类)
        // 1.通过@Bean方式定义
//        beanFactory.register(Config.class);
//        beanFactory.register(AnnotationBeanDefinitionDemo.class);
        registerBeanDefinition(beanFactory, User.class);
        registerBeanDefinition(beanFactory, "luoji", User.class);

        beanFactory.refresh();

        lookupByType(beanFactory);
        // 显示关闭spring应用上下文
        beanFactory.close();
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        beanDefinitionBuilder.addPropertyValue("id", 2L).addPropertyValue("name", "jackson");

        if (StringUtils.hasText(beanName)) {
            // 注册BeanDefinition
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 注册BeanDefinition
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry, Class<?> beanClass) {
        registerBeanDefinition(registry, null, beanClass);
    }


    private static void lookupByType(BeanFactory factory) {
        if (factory instanceof ListableBeanFactory) {
            Map<String, User> beanMap = (Map<String, User>) ((ListableBeanFactory) factory).getBeansOfType(User.class);
            beanMap.entrySet().forEach(item -> {
                System.out.println(item.getValue());
            });
            return;
        }
        User user = factory.getBean(User.class);
        System.out.println("by type: " + user);
    }

    @Component
    static class Config {
        @Bean(name = {"xiaowang", "wangxiaoer"})
        User user() {
            User user = new User();
            user.setId(31L);
            user.setName("小王");
            return user;
        }
    }
}
