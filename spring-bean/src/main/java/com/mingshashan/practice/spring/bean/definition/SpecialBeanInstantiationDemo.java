package com.mingshashan.practice.spring.bean.definition;

import com.mingshashan.practice.spring.bean.factory.DefaultUserFactory;
import com.mingshashan.practice.spring.bean.factory.UserFactory;
import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        ServiceLoader<UserFactory> serviceLoader = applicationContext.getBean("userFactoryServiceLoader", ServiceLoader.class);
        displayServiceLoader(serviceLoader);

        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());
    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    public static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> userFactoryIterator = serviceLoader.iterator();
        while (userFactoryIterator.hasNext()) {
            System.out.println(userFactoryIterator.next().createUser());
        }
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
