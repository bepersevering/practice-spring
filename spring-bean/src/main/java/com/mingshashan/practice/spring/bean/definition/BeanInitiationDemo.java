package com.mingshashan.practice.spring.bean.definition;

import com.mingshashan.practice.spring.bean.factory.DefaultUserFactory;
import com.mingshashan.practice.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * bean初始化demo
 */
@Configuration
public class BeanInitiationDemo {
    public static void main(String[] args) {
        // 1.BeanFactory容器
        AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext();
        beanFactory.register(BeanInitiationDemo.class);
        beanFactory.refresh();
        System.out.println("spring应用上下文已经启动...");
        UserFactory userFactory = beanFactory.getBean(UserFactory.class);
        System.out.println(userFactory);
        System.out.println("spring应用上下文准备销毁...");
        beanFactory.close();
        System.out.println("spring应用上下文已销毁...");
    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "destroyUserFactory")
//    @Lazy
    @Lazy(value = false)
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
