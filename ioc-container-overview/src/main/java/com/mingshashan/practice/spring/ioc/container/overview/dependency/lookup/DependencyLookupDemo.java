package com.mingshashan.practice.spring.ioc.container.overview.dependency.lookup;

import com.mingshashan.practice.spring.ioc.container.overview.annotation.Super;
import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");

        lookupRealTime(factory);
        lookupLazy(factory);
        lookupCollectionByType(factory);
        lookupByAnnotationType(factory);
    }

    private static void lookupByAnnotationType(BeanFactory factory) {
        if (factory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) factory;
            Map<String, User> collection = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("lookupByAnnotationType @Super: " + collection);
        }
    }

    private static void lookupCollectionByType(BeanFactory factory) {
        if (factory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) factory;
            Map<String, User> collection = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookupCollectionType: " + collection);
        }
    }

    private static void lookupRealTime(BeanFactory factory) {
        lookupByName(factory);
        lookupByType(factory);
    }

    private static void lookupLazy(BeanFactory factory) {
        ObjectFactory<User> objectFactory = (ObjectFactory) factory.getBean("objectFactory");

        User user = objectFactory.getObject();
        System.out.println("lookup lazy: " + user);
    }

    private static void lookupByType(BeanFactory factory) {
        User user = factory.getBean(User.class);
        System.out.println("by type: " + user);
    }

    private static void lookupByName(BeanFactory factory) {
        User user = (User) factory.getBean("user");
        System.out.println("by name: " + user);
    }
}
