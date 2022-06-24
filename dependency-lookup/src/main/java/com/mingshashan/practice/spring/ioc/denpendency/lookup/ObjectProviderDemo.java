package com.mingshashan.practice.spring.ioc.denpendency.lookup;

import com.mingshashan.practice.spring.ioc.container.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;

public class ObjectProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);

        applicationContext.refresh();

        lookupByObjectProvider(applicationContext);
        lookupByIfAvailable(applicationContext);
        lookupByStreamOps(applicationContext);
        applicationContext.close();
    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        Iterable<String> stringIterable = objectProvider;
        for (String s : stringIterable) {
            System.out.println(s);
        }

        objectProvider.stream().forEach(System.out::println);
    }

    private static void lookupByIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);
        User user = objectProvider.getIfAvailable(User::createUser);
        System.out.println(user);
    }

    @Bean
    public String hello() {
        return "Hello";
    }
    @Bean
    public String message() {
        return "messge";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);

        System.out.printf(objectProvider.getObject());
    }
}
