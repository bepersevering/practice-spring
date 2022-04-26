package com.mingshashan.practice.spring.ioc.container.overview.container;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * ioc container
 * 注解能力的{@link org.springframework.context.ApplicationContext} 作为IoC容器示例
 */
public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        applicationContext.refresh();
        lookupCollectionByType(applicationContext);
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(11L);
        user.setName("小张");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory factory) {
        if (factory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) factory;
            Map<String, User> collection = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookupCollectionType: " + collection);
        }
    }
}
