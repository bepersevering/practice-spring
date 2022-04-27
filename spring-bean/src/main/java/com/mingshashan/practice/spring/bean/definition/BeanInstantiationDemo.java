package com.mingshashan.practice.spring.bean.definition;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class BeanInstantiationDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");

        User userByStaticMethod = beanFactory.getBean("user-by-static-method", User.class);
        System.out.println("user-by-static-method: " + userByStaticMethod);

        User userByFactory = beanFactory.getBean("user-by-instance-method", User.class);
        System.out.println("user-by-instance-method: " + userByFactory);

        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println("user-by-factory-bean: " + userByFactoryBean);


        // 显示关闭spring应用上下文
        beanFactory.close();
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

}
