package com.mingshashan.practice.spring.bean.definition;

import com.mingshashan.practice.spring.bean.factory.DefaultUserFactory;
import com.mingshashan.practice.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingletonBeanRegistrationBean {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        UserFactory userFactory = new DefaultUserFactory();
        SingletonBeanRegistry singletonBeanRegistry = applicationContext.getBeanFactory();
        // 注册外部单例对象 UserFactory
        singletonBeanRegistry.registerSingleton("userFactory", userFactory);

        // 启动Spring应用上下文
        applicationContext.refresh();

        UserFactory userFactoryByLookup = applicationContext.getBean("userFactory", UserFactory.class);
        System.out.println("userFactory == userFactoryByLookup : " + (userFactory == userFactoryByLookup));

        // 关闭Spring应用上下文
        applicationContext.close();

    }
}
