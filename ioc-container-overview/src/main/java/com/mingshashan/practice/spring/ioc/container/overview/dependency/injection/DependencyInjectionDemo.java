package com.mingshashan.practice.spring.ioc.container.overview.dependency.injection;

import com.mingshashan.practice.spring.ioc.container.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class DependencyInjectionDemo {

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");

        UserRepository userRepository = (UserRepository) factory.getBean("userRepository");
        // 依赖注入
        System.out.println(userRepository.getUsers());
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == factory);

        // 依赖查找，与依赖注入不是来自同一地方
        // NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.beans.factory.BeanFactory' available
        // System.out.println(factory.getBean(BeanFactory.class));

        System.out.println(userRepository.getUserObjectFactory().getObject());
        System.out.println(userRepository.getObjectFactory());
        System.out.println(userRepository.getObjectFactory().getObject() == factory);

        // 自定义bean: 如 UserRepository
        // 非bean: BeanFactory（内建依赖）
        // 内建bean， Environment

        Environment environment = factory.getBean(Environment.class);
        System.out.println("获取Environment类型的bean: " + environment);
    }
}
